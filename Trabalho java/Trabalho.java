import java.util.Scanner;
public class Trabalho {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // scan para ler numeros
        Scanner scan1 = new Scanner(System.in); // scan para ler Strings

        int n, i = 0;
        Double val_total=0.0;
        int[] cont_carro = new int[3], cont_lavtipo = new int[3];
        String[] nome;
        double[][] preco = {{50.00,70.00,90.00},{70.00,90.00,110.00},{90.00,110.00,130.00}};
        char pergunta;
        
        
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
                    System.out.println(carro[x]);
                }
                System.out.print("Informe o modelo do carro: ");
                c[i] = scan.nextInt()-1;

                if(c[i] != 0 && c[i] != 1 && c[i] != 2)
                {
                System.out.println("\n\nOperação invalida!\n\n");
                }
                
            } while(c[i] != 0 && c[i] != 1 && c[i] != 2);
            //tipo de serviço
            do
            {
                System.out.println("\nSendo os tipos de serviço como:");
                for(int x = 0; x < 3; x++)
                {
                    System.out.println(lavtipo[x]);
                }
                System.out.print("Informe o tipo de lavação desejada: ");
                l[i] = scan.nextInt()-1;

            if(l[i] != 0 && l[i] != 1 && l[i] != 2)
            {
                System.out.println("\n\nOperação invalida!\n\n");
            }


            } while(l[i] != 0 && l[i] != 1 && l[i] != 2);

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
        System.out.print("\nRelação geral de clientes:");
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        //relação geral dos clientes
        for(i=0;i<n;i++){
            System.out.println(nome[i] + "\n\nCarro selecionado:\n" + carro[c[i]] + "\n\nServiço selecionado:\n" + lavtipo[l[i]] + "\n\nValor pago\n" + preco[c[i]][l[i]]);
            System.out.println("-------------------------------------------------------------");
        }

        System.out.print("\nClique em S para ver os percentuais: ");
        pergunta = scan.next().charAt(0);

        System.out.print("\033[H\033[2J");

        //percentuais
        if (pergunta == 's' || pergunta == 'S') {
            System.out.println("Percentuais");
            System.out.println("--------------------------------------------------------------------");
            percentuais(carro, lavtipo, cont_carro, cont_lavtipo, n);
        }

        System.out.print("\nClique em S para ver o total arrecadado: ");
        pergunta = scan.next().charAt(0);

        System.out.print("\033[H\033[2J");

        //Total arrecadado
        if (pergunta == 's' || pergunta == 'S') {
            System.out.println("Valor total arrecadado");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Total arrecadado: " + val_total);
        }

        System.out.print("\nClique em S para ver qual o tipo do veículo e o serviço que foram o mais atendidos: ");
        pergunta = scan.next().charAt(0);

        System.out.print("\033[H\033[2J");

        if (pergunta == 's' || pergunta == 'S') {
            System.out.println("Veículo(s) e serviço(s) que foi o mais atendido");
            System.out.println("--------------------------------------------------------------------");
            mais_atendidos(cont_carro, carro, cont_lavtipo, lavtipo);
        }
            
        scan.close();
        scan1.close();
    }
    // Subprograma referente ao carro e veículo que foram mais atendidos
    public static void mais_atendidos(int cont_carro[], String carro[], int cont_lavtipo[], String lavtipo[]){
        int maxCarro = 0, maxLavtipo = 0;
        for (int i = 1; i < cont_carro.length; i++) {
            if (cont_carro[i] > cont_carro[maxCarro]) {
                maxCarro = i;
            }
        }
        for (int i = 1; i < cont_lavtipo.length; i++) {
            if (cont_lavtipo[i] > cont_lavtipo[maxLavtipo]) {
                maxLavtipo = i;
            }
        }
        System.out.println("Carro: " + carro[maxCarro]);
        System.out.println("Serviço: " + lavtipo[maxLavtipo]);
        
    }
    //Subprograma referente ao percentuais
    public static void percentuais(String carro[], String lavtipo[], int cont_carro[], int cont_lavtipo[], int n){
        System.out.println("Carros");
        for(int i = 0; i < 3; i++){
            System.out.println("\t- "+ carro[i] + ": " + (cont_carro[i] = (cont_carro[i] * 100) / n) + "%");
        }
        System.out.println("Serviços");
        for(int i = 0; i < 3; i++){
                System.out.println("\t- "+ lavtipo[i] + ": " + (cont_lavtipo[i] = (cont_lavtipo[i] * 100) / n) + "%");
        }
    }
}