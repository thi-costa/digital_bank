public class Main {
    public static void main(String[] args) {
        Cliente antonio = new Cliente();
        antonio.setNome("Antônio");

        ContaCorrente contaCorrente1 = new ContaCorrente(antonio);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(antonio);

        contaCorrente1.depositar(100);
        contaCorrente1.transferir(50, contaPoupanca1);

        contaCorrente1.imprimirExtrato();
        contaPoupanca1.imprimirExtrato();
    }
}