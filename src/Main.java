import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        boolean isActive = true;
        String startMensage = """
                ##########################################
                #        MarllonX Microservices ~*       #
                ##########################################
                """;
        Conta conta1 = new Conta(1, "Marllon santos", 100000); //Eu mesmo
        Conta conta2 = new Conta(2, "Débora santos", 100000); //Minha esposa
        Conta conta3 = new Conta(3, "Davi santos", 10000); //Filho com 2 anos
        Conta conta4 = new Conta(4, "Miguel santos", 10000); //Filho com 7 mêses

        Conta[] listaContas = { conta1, conta2, conta3, conta4 };

        Scanner scanner = new Scanner(System.in);

        System.out.println(startMensage);
        while(isActive){
            Thread.sleep(300);
            System.out.println("""
                    ##########################################
                    #            Menu Principal  ~*          #
                    #                                        #
                    #          1. Consultar Saldo;           #
                    #                                        #
                    #           2. Transferir;               #
                    #                                        #
                    #           3. Depositar;                #
                    #                                        #
                    #              4. Sair.                  #
                    #                                        #
                    ##########################################
                    Digite a opção:""");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    conta1.consultaConta();
                    break;
                case 2:
                    System.out.println("Informe o id da conta que quer realizar a transferência:");
                    int receiverId = scanner.nextInt();

                    Conta contaDestino = null;
                    for (Conta conta : listaContas) {
                        if (conta.getId() == receiverId) {
                            contaDestino = conta;
                            break;
                        }
                    }
                    if (contaDestino != null) {
                        System.out.println("Digite o valor que deseja transferir:");
                        double ammountValue = scanner.nextDouble();
                        conta1.transferencia(contaDestino, ammountValue);
                        System.out.printf("Transferência realizada para %s\n", contaDestino.getNome());
                        Thread.sleep(300);
                    } else {
                        System.out.println("Conta com o ID informado não foi encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Informe o valor que irá depositar na conta:");
                    double valueDep = scanner.nextDouble();
                    conta1.deposito((valueDep));

                    break;
                case 4:
                    isActive = false;
                    break;
                default:
                    System.out.println("Ops! Digite uma opção válida");
                    break;
            }

        }


    }
}
