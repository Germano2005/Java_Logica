import java.util.Scanner;
public class Trabalho3 {
    
    public static void main(String[] args) {
        
        int n, i = 0;
        Double val_total=0.0;
        int[] cont_carro = new int[3], cont_lavtipo = new int[3];
        String[] nome;
        double[][] preco = {{50.00,70.00,90.00},{70.00,90.00,110.00},{90.00,110.00,130.00}};
        char pergunta;
        String v_mais = "", c_mais = "";
        
        
        String carro[] = {"Pequeno (populares)", "Médio (SUV e Picape)", "Grande (Van e micro-ônibus)"};
        String lavtipo[] = {"Lavação externa", "Lavação externa + interna", "Lavação externa + interna + cera."};

        Scanner scan = new Scanner(System.in);
       

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
                nome[i] = scan.next();
            
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
                c_mais = carro[0];
            }
            else if(c[i] == 1)
            {
                cont_carro[1]++;
                c_mais = carro[1];
            }
            else
            {
                cont_carro[2]++;
                c_mais = carro[2];
            }
            
            if(l[i] == 0)
            {
                cont_lavtipo[0]++;
                v_mais = lavtipo[0];
            }
            else if(l[i] == 1)
            {
                cont_lavtipo[1]++;
                v_mais = lavtipo[1];
            }
            else
            {
                cont_lavtipo[2]++;
                v_mais = lavtipo[2];
            }

            val_total = val_total + preco[c[i]][l[i]];
        }
        System.out.print("\n\nRelação geral de clientes:");
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        for(i=0;i<n;i++){
            System.out.println(nome[i] + "\n\nCarro selecionado:\n" + carro[c[i]] + "\n\nServiço selecionado:\n" + lavtipo[l[i]] + "\n\nValor pago\n" + preco[c[i]][l[i]]);
            System.out.println("-------------------------------------------------------------");
        }

        System.out.print("\nClique em S para ver os percentuais: ");
        pergunta = scan.next().charAt(0);

        System.out.print("\033[H\033[2J");

        if (pergunta == 's' || pergunta == 'S') {
            System.out.println("Percentuais");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Carros");
            System.out.println("\t- pequeno (populares): " + (cont_carro[0] = (cont_carro[0] * 100) / n) + "%");
            System.out.println("\t- médio (SUV e Picape): " + (cont_carro[1] = (cont_carro[1] * 100) / n) + "%");
		    System.out.println("\t- grande(s) (Van e micro-ônibus): " + (cont_carro[2] = (cont_carro[2] * 100) / n) + "%");
            System.out.println("Serviços");
            System.out.println("\t- lavação interna: " + (cont_lavtipo[0] = (cont_lavtipo[0] * 100) / n) + "%");
            System.out.println("\t- lavação interna + lavação extrena: " + (cont_lavtipo[1] = (cont_lavtipo[1] * 100) / n) + "%");
            System.out.println("\t- lavação interna + lavação extrena + cera: " + (cont_lavtipo[2] = (cont_lavtipo[2] * 100) / n) + "%");
        }

        System.out.print("\nClique em S para ver o total arrecadado: ");
        pergunta = scan.next().charAt(0);

        System.out.print("\033[H\033[2J");

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
            System.out.println("Veículo(s)" + c_mais);
            System.out.println("Serviço(s)" + v_mais);
        }
            
        scan.close();
    }
}
