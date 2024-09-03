import java.util.Scanner;


public class Trabalho_logica 
{

    public static void main(String[] args) 
    {
       
        int n, i=0;
        Double val_total=0.0;
        int[] cont_carro = new int[3], cont_lavtipo = new int[3];
        String[] nome;
        double[][] preco = {{50.00,70.00,90.00},{70.00,90.00,110.00},{90.00,110.00,130.00}};
        
        String carro[] = {"Pequeno (populares)", "Médio (SUV e Picape)", "Grande (Van e micro-ônibus)"};
        String lavtipo[] = {"Lavação externa", "Lavação externa + interna", "Lavação externa + interna + cera."};

        Scanner anum_scan = new Scanner(System.in);
        Scanner nome_scan = new Scanner(System.in);
        Scanner carro_scan = new Scanner(System.in);
        Scanner tipo_scan = new Scanner(System.in);

        System.out.print("Informe o número de atendimentos a ser efetuado: ");
        n = anum_scan.nextInt();
        nome = new String[n];
        int[] c = new int[n];
        int[] l = new int[n];

        //repetição por número de atendimentos
        for( i=0 ; i<n ; i++ )
        {
            System.out.print("Informe o nome do cliente: ");
                    nome[i] = nome_scan.nextLine();
                
            //tipo de carro
            do
            {
                System.out.println("\nSendo os tipos de carro como:\n1 - Pequeno (populares)\n2 - Médio (SUV e Picape)\n3 - Grande (Van e micro-ônibus)");
                System.out.print("Informe o modelo do carro: ");
                    c[i] = carro_scan.nextInt()-1;

                if(c[i] != 0 && c[i] != 1 && c[i] != 2)
                {
                System.out.println("\n\nOperação invalida!\n\n");
                }
                    
            } while(c[i] != 0 && c[i] != 1 && c[i] != 2);
            //tipo de serviço
            do
            {
            System.out.println("\nSendo os tipos de serviço como:\n1 - Lavação externa\n2 - Lavação externa + interna\n3 - Lavação externa + interna + cera.");
            System.out.print("Informe o tipo de lavação desejada: ");
                l[i] = tipo_scan.nextInt()-1;

            if(l[i] != 0 && l[i] != 1 && l[i] != 2)
            {
                System.out.println("\n\nOperação invalida!\n\n");
            }
            } while(l[i] != 0 && l[i] != 1 && l[i] != 2);

            //Apresentação dos dados informados
            System.out.println("\n-----------------------------------------------------------------------------------\n");
            System.out.println(nome[i] + "\n\nCarro selecionado:\n" + carro[c[i]] + "\n\nServiço selecionado:\n" + lavtipo[l[i]] + "\n\nValor pago\n" + preco[c[i]][l[i]]);
            System.out.println("\n-----------------------------------------------------------------------------------\n");
                
            if(c[i] == 1)
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
                
            if(l[i] == 1)
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
        for(i=0;i<n;i++)
        {
            System.out.print("\n\nRelação geral de clientes:");
            System.out.println("\n-----------------------------------------------------------------------------------\n");
            System.out.println(nome[i] + "\n\nCarro selecionado:\n" + carro[c[i]] + "\n\nServiço selecionado:\n" + lavtipo[l[i]] + "\n\nValor pago\n" + preco[c[i]][l[i]]);
        }

        System.out.println("\nEssa é a porcentagem de carro(s) pequeno(s) (populares): " + (cont_carro[0] = (cont_carro[0] * 100) / n) + "%");
		System.out.println("\nEssa é a porcentagem de carro(s) médio(s) (SUV e Picape): " + (cont_carro[1] = (cont_carro[1] * 100) / n) + "%");
		System.out.println("\nEssa é a porcentagem de carro(s) grande(s) (Van e micro-ônibus): " + (cont_carro[2] = (cont_carro[2] * 100) / n) + "%");
        System.out.println("\nEssa é a porcentagem de serviço(s) de lavação interna : " + (cont_lavtipo[0] = (cont_lavtipo[0] * 100) / n) + "%");
		System.out.println("\nEssa é a porcentagem de serviço(s) de lavação interna + lavação externa: " + (cont_lavtipo[1] = (cont_lavtipo[1] * 100) / n) + "%");
		System.out.println("\nEssa é a porcentagem de serviço(s) de lavação interna + lavação externa + cera: " + (cont_lavtipo[2] = (cont_lavtipo[2] * 100) / n) + "%");
    }
}