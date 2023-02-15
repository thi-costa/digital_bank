import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Banco {
    public String nome;
    private List<Conta> listaContas;
    private List<Cliente> listaClientes;

    public Banco(String nome, List<Conta> listaContas,List<Cliente> listaClientes){
        this.nome = nome;
        this.listaContas = listaContas;
        this.listaClientes = listaClientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas(){
        return listaContas;
    }
    public void setContas(List<Conta> listaContas){
        this.listaContas = listaContas;
    }
    public List<Cliente> getClientes(){
        return listaClientes;
    }
    public void setClientes(List<Cliente> listaClientes){
        this.listaClientes = listaClientes;
    }

    public void imprimirListaDeClientesESuasContas(){
        System.out.println("\n=== Lista de Clientes e suas contas ===\n");
        listaClientes.stream().map(cliente -> {
            System.out.println("Cliente: " + cliente.getNome());
            return cliente.getId();
        })
            .map(id -> {
                return listaContas.stream()
                    .filter(conta -> conta.getClienteId() == id).collect(Collectors.toList());
            }).forEach(contas -> {
                imprimirInformacoesDeCadaConta(contas);;
            });
    }

    private void imprimirInformacoesDeCadaConta(List<Conta> contas) {
        for(Conta conta: contas){
            System.out.println("\nConta " + conta.getTipoDeConta());
            System.out.printf("\tAgência: %d\n\tNúmero: %d\n\tSaldo: R$ %.2f\n\n",
            conta.getAgencia(), conta.getNumero(), conta.getSaldo());
        }
    }

    public void imprimirSaldoTotalDeCadaCliente(){
        double valorTotal = 0;
        System.out.println("\n=== Saldo total de cada cliente ===\n");
        listaClientes.stream().map(cliente -> {
            System.out.println("Cliente: " + cliente.getNome());
            return cliente.getId();
        })
            .map(id -> {
                return listaContas.stream()
                    .filter(conta -> conta.getClienteId() == id)
                    .map(conta -> conta.getSaldo());
            }).forEach(saldo -> {
                System.out.printf("\t Valor total: R$ %.2f\n", saldo.reduce(0.0, (x, y)-> x + y ));
            });
                
    }
}
