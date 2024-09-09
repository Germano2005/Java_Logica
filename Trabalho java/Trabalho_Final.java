//Trabalho feito por Alunos: Leonardo Ferreira Damasio e Germano Dolwitsch Coelho







import java.util.Scanner;
public class Trabalho {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // scan para ler numeros
        Scanner scan1 = new Scanner(System.in); // scan para ler Strings
        Scanner filtro = new Scanner(System.in);

        int n, i = 0;
        Double val_total=0.0;
        int[] cont_carro = new int[3], cont_lavtipo = new int[3];
        String[] nome;
        double[][] preco = {{50.00,70.00,90.00},{70.00,90.00,110.00},{90.00,110.00,130.00}};
        int pergunta;
        String relatorio[] = {"1- Relação geral dos clientes", "2- Percentuais", "3- Total arrecado", "4- Mais atendidos ", "5- Pesquisa especializada"};
        
        
        String carro[] = {"Pequeno (populares)", "Médio (SUV e Picape)", "Grande (Van e micro-ônibus)"};
        String lavtipo[] = {"Lavação externa", "Lavação externa + interna", "Lavação externa + interna + cera"};

        System.out.print("Informe o número de atendimentos a ser efetuado: ");
        n = scan.nextInt();
        nome = new String[n];

        int[] c = new int[n];
        int[] l = new int[n];

        System.out.print("\033[H\033[2J");
        
        //repetição por número de atendimentos
        for( i=0 ; i<n ; i++ )
        {
            System.out.print("Informe o nome do cliente: ");
                nome[i] = scan1.nextLine();
            
            //tipo de carro
            do
            {
                System.out.println("\nSendo os tipos de carro como:");
                for(int x = 0; x < 3; x++)
                {
                    System.out.println((x + 1) + "- " + carro[x]);
                }
                System.out.print("Informe o modelo do carro: ");
                c[i] = scan.nextInt()-1;

                if(c[i] < 0 || c[i] > 2)
                {
                System.out.println("\n\nOperação invalida!\n\n");
                }
                
            } while(c[i] < 0 || c[i] > 2);
            //tipo de serviço
            do
            {
                System.out.println("\nSendo os tipos de serviço como:");
                for(int x = 0; x < 3; x++)
                {
                    System.out.println((x + 1) + "- " + lavtipo[x]);
                }
                System.out.print("Informe o tipo de lavação desejada: ");
                l[i] = scan.nextInt()-1;

            if(l[i] < 0 || l[i] > 2)
            {
                System.out.println("\n\nOperação invalida!\n\n");
            }

            } while(l[i] < 0 || l[i] > 2);

            System.out.print("\033[H\033[2J");

            if(c[i] == 0)
            {
                cont_carro[0]++;
            }
            else if(c[i] == 1)
            {
                cont_carro[1]++;
            }
            else
            {
                cont_carro[2]++;
            }
            
            if(l[i] == 0)
            {
                cont_lavtipo[0]++;
            }
            else if(l[i] == 1)
            {
                cont_lavtipo[1]++;
            }
            else
            {
                cont_lavtipo[2]++;
            }

            val_total = val_total + preco[c[i]][l[i]];
        }

        //menu
        System.out.println("Menu");
        System.out.println("----------------------------------------------------------");

        for(i = 0; i < 5; i++)
        {
            System.out.println(relatorio[i]);
        }

        System.out.print("\nDigite o numero correspondede ou digite 6 para sair: ");
        pergunta = scan1.nextInt();

        do {
            //relação geral dos clientes

            if (pergunta > 6 || pergunta <= 0) {
                System.out.println("\nIntervalo errado, digite novamente abaixo");

                System.out.print("\nDigite o numero correspondede ou digite 6 para sair: ");
                pergunta = scan1.nextInt();
            }

            if (pergunta == 1) {
                System.out.print("\033[H\033[2J");
                System.out.print("\nRelação geral de clientes:");
                System.out.println("\n-----------------------------------------------------------------------------------");

                for(i=0;i<n;i++){
                    System.out.println(nome[i] + "\n\nCarro selecionado:\n" + carro[c[i]] + "\n\nServiço selecionado:\n" + lavtipo[l[i]] + "\n\nValor pago\n" + preco[c[i]][l[i]]);
                    System.out.println("--------------------------------------------------------------------");
                }
            }
            //percentuais
            else if (pergunta == 2) {
                System.out.print("\033[H\033[2J");
                System.out.println("Percentuais");
                System.out.println("--------------------------------------------------------------------");
                percentuais(carro, lavtipo, cont_carro, cont_lavtipo, n);
                System.out.println("--------------------------------------------------------------------");

            }
            //Total arrecadado
            else if (pergunta == 3){
                System.out.print("\033[H\033[2J");
                System.out.println("Valor total arrecadado");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Total arrecadado: " + val_total);
                System.out.println("--------------------------------------------------------------------");
            }
            //Carro e serviço mais atendidos
            else if (pergunta == 4) {
                System.out.print("\033[H\033[2J");
                System.out.println("Veículo(s) e serviço(s) que foi o mais atendido");
                System.out.println("--------------------------------------------------------------------");
                mais_atendidos(cont_carro, carro, cont_lavtipo, lavtipo);
                System.out.println("--------------------------------------------------------------------");
            }
            //pesquisa especializada
            else if (pergunta == 5) {
                System.out.print("\033[H\033[2J");
                System.out.println("Pesquisa especializada conforme o tipo de carro e serviço selecionado");
                System.out.println("--------------------------------------------------------------------");
                pesqfiltro(nome, carro, lavtipo, preco, n, c, l, filtro);
                System.out.println("--------------------------------------------------------------------");
            }
            else if(pergunta == 6){
                break;
            }

            for(i = 0; i < 5; i++)
            {
                System.out.println(relatorio[i]);
            }

            System.out.print("\nDigite o numero correspondede ou digite 6 para sair: ");
            pergunta = scan1.nextInt();

            } while (pergunta != 6);

            System.out.println("Fim do programa!!!!!");
         
    }
    // Subprograma referente ao carro e veículo que foram mais atendidos
    public static void mais_atendidos(int cont_carro[], String carro[], int cont_lavatipo[], String lavtipo[])
    {
        System.out.println("Carros");
        if (cont_carro[0] >= cont_carro[1] && cont_carro[0] >= cont_carro[2]) {
            System.out.println("\t- "+carro[0]);
        }
        if (cont_carro[1] >= cont_carro[0] && cont_carro[1] >= cont_carro[2]) {
            System.out.println("\t- "+carro[1]);
        }
        if (cont_carro[2] >= cont_carro[0] && cont_carro[2] >= cont_carro[1]) {
            System.out.println("\t- "+carro[2]);
        }
        System.out.println("Serviços");
        if (cont_lavatipo[0] >= cont_lavatipo[1] && cont_lavatipo[0] >= cont_lavatipo[2]) {
            System.out.println("\t- "+lavtipo[0]);
        }
        if (cont_lavatipo[1] >= cont_lavatipo[0] && cont_lavatipo[1] >= cont_lavatipo[2]) {
            System.out.println("\t- "+lavtipo[1]);
        }
        if (cont_lavatipo[2] >= cont_lavatipo[0] && cont_lavatipo[2] >= cont_lavatipo[1]) {
            System.out.println("\t- "+lavtipo[2]);
        }
    }
    //Subprograma referente ao percentuais
    public static void percentuais(String carro[], String lavtipo[], int cont_carro[], int cont_lavtipo[], int n)
    {
        System.out.println("Carros");
        for(int i = 0; i < 3; i++){
            System.out.println("\t- "+ carro[i] + ": " + (cont_carro[i] * 100) / n + "%");

        }
        System.out.println("Serviços");
        for(int i = 0; i < 3; i++){
            System.out.println("\t- "+ lavtipo[i] + ": " + (cont_lavtipo[i] * 100) / n  + "%");
        }
    }
    // subprograma referente a pesquisa personalizada
    public static void pesqfiltro(String nome[], String carro[], String lav_tipo[], double preco[][], int n, int c[], int l[],  Scanner filtro)
    {
        int carro_filtro, lav_filtro, k = 0;

        do
        {
            System.out.println("\nSendo os tipos de carro como:");
            for(int x = 0; x < 3; x++)
            {
                System.out.println((x + 1) + "- " +carro[x]);
            }
            System.out.print("Informe o modelo do carro: ");
            carro_filtro = filtro.nextInt()-1;

            if(carro_filtro < 0 || carro_filtro > 2)
            {
            System.out.println("\n\nOperação invalida!\n\n");
            }
                
        } while(carro_filtro < 0 || carro_filtro > 2);
        
        System.out.println("\nSendo os tipos de serviço como:");
        for(int x = 0; x < 3; x++)
        {
            System.out.println((x + 1) + "- " +lav_tipo[x]);
        }

        do
        {
        System.out.print("Informe o tipo de lavação desejada: ");
        lav_filtro = filtro.nextInt()-1;

        if(lav_filtro < 0 || lav_filtro > 2)
        {
            System.out.println("\n\nOperação invalida!\n\n");
        }

        } while(lav_filtro < 0 || lav_filtro > 2);

        for(int i=0;i<n;i++) 
        {
            if(c[i] == carro_filtro && l[i] == lav_filtro)
            {
                System.err.println("-------------------------------------------------------------");
                System.out.println(nome[i] +  "\n\nValor pago\n" + preco[carro_filtro][lav_filtro]); // aqui ele vai mostra os preços conforme os filtros
            }
            else{
                k++;
            }
        }
        if (k == n) {
                System.out.println("\nNão há nenhum cliente nessa pesquisa"); // essa condição serve para verificar quando não há um cliente no intervalo desejado
        }
    }
}
