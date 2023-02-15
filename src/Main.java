import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        List<Conta> listaContas = new ArrayList<Conta>();

        Cliente antonio = new Cliente("Antônio Lima");
        Cliente jose = new Cliente("José Carlos");

        ContaCorrente contaCorrenteAntonio = new ContaCorrente(antonio, "Corrente");
        ContaPoupanca contaPoupancaAntonio = new ContaPoupanca(antonio, "Poupança");

        contaCorrenteAntonio.depositar(100.0);
        contaCorrenteAntonio.transferir(50.0, contaPoupancaAntonio);

        contaCorrenteAntonio.imprimirExtrato();

        ContaCorrente contaCorrenteJose = new ContaCorrente(jose, "Corrente");
        ContaPoupanca contaPoupancaJose = new ContaPoupanca(jose, "Poupança");

        contaCorrenteJose.depositar(100000.0);
        contaCorrenteJose.transferir(5000.0, contaPoupancaJose);

        contaCorrenteJose.imprimirExtrato();
        contaPoupancaJose.imprimirExtrato();

        // Adição de clientes e contas às listas
        listaClientes.add(antonio);
        listaClientes.add(jose);
        listaContas.add(contaCorrenteAntonio);
        listaContas.add(contaPoupancaAntonio);
        listaContas.add(contaCorrenteJose);
        listaContas.add(contaPoupancaJose);

        // Novos métodos adicionados com criação do Banco

        Banco bancoDoBrasil = new Banco("Banco do Brasil", listaContas, listaClientes);

        bancoDoBrasil.imprimirListaDeClientesESuasContas();

        bancoDoBrasil.imprimirSaldoTotalDeCadaCliente();

        
    }
}