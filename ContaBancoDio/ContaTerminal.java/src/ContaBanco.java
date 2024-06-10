import java.util.Scanner;

public class ContaBanco {
    private int numeroAgencia;
    private int senha;
    private String nome;
    private double saldo;

    public ContaBanco(int numeroAgencia, int senha, String nome, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.senha = senha;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número da agência:");
        int numeroAgencia = scanner.nextInt();

        System.out.println("Digite a senha:");
        int senha = scanner.nextInt();

        System.out.println("Digite o nome:");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Digite o saldo inicial:");
        double saldo = scanner.nextDouble();

        ContaBanco conta = new ContaBanco(numeroAgencia, senha, nome, saldo);

        System.out.println("Olá " + conta.nome + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + conta.numeroAgencia + ", conta " + conta.hashCode() + " e seu saldo R$"
                + conta.saldo + " já está disponível para saque.");

        System.out.println("\nDigite o valor a ser depositado:");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        System.out.println("\nDigite o valor a ser sacado:");
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        scanner.close();
    }
}