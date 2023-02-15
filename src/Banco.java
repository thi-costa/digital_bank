import java.util.List;

public class Banco {
    public String nome;
    private List<Conta> listaContas;
    private List<Cliente> listaClientes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
