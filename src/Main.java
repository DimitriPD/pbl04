import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Conta> listaConta = new ArrayList<Conta>();
        Conta conta;
        int num_conta = 1;
        boolean loop = true;
        int contaPesquisada = 0;

        while (loop){
            System.out.println("1- Criar Conta" +
                    "\n2- Ver saldo" +
                    "\n3- Sacar" +
                    "\n4-Depositar" +
                    "\n5-Sair");
            int escolha = scan.nextInt();

            switch (escolha){
                case 1:
                    conta = new Conta(num_conta);
                    System.out.print("Nome do Titular: ");
                    conta.setNomeTitular(scan.next());

                    System.out.print("Saldo inicial: ");
                    if (!conta.setSaldo(scan.nextDouble())) {
                        System.out.println("Saldo inicial deve ser positivo.");
                        break;
                    }

                    listaConta.add(conta);
                    num_conta += 1 ;
                    System.out.println("Conta criada! numero da conta " + conta.getNumeroConta());
                    break;

                case 2 :
                    if (listaConta.isEmpty()) {
                        System.out.println("Nenhum conta foi cadastrada.");
                        break;
                    }

                    System.out.print("Numero da conta: ");
                    contaPesquisada = scan.nextInt();

                    if (contaPesquisada > listaConta.size() || contaPesquisada <= 0) {
                        System.out.println("Conta não existe.");
                        break;
                    }

                    conta = listaConta.get(contaPesquisada - 1);
                    System.out.println("Saldo: " + conta.getSaldo());

                    break;
                case 3 :
                    if (listaConta.isEmpty()) {
                        System.out.println("Nenhum conta foi cadastrada.");
                        break;
                    }

                    System.out.println("Numero da conta: ");
                    contaPesquisada = scan.nextInt();

                    if (contaPesquisada > listaConta.size() || contaPesquisada <= 0) {
                        System.out.println("Conta não existe.");
                        break;
                    }

                    conta = listaConta.get(contaPesquisada - 1);
                    System.out.println("Valor do saque: " );
                    double valorSaque = scan.nextDouble();
                    System.out.println(conta.sacar(valorSaque));
                    break;
                case 4 :
                    if (listaConta.isEmpty()) {
                        System.out.println("Nenhum conta foi cadastrada.");
                        break;
                    }

                    System.out.println("Numero da conta: ");
                    contaPesquisada = scan.nextInt();

                    if (contaPesquisada > listaConta.size() || contaPesquisada <= 0) {
                        System.out.println("Conta não existe.");
                        break;
                    }

                    conta = listaConta.get(contaPesquisada -1);
                    System.out.println("Valor do deposito: " );
                    double valorDeposito = scan.nextDouble();
                    System.out.println(conta.depositar(valorDeposito));
                    break;
                case 5 :
                    System.out.println("Programa encerrado.");
                    loop = false;
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }
}