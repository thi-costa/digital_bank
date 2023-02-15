public abstract class Conta implements IConta {
    private final static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }


    public int getNumero() {
        return numero;
    }


    public double getSaldo() {
        return saldo;
    }


    @Override
    public void sacar(double valor) {
        saldo -= valor;        
    }


    @Override
    public void depositar(double valor) {
        saldo += valor; 
    }


    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInformacoesConta() {
        System.out.printf("Titular: %s\nAgencia: %d\nNúmero: %d\nSaldo: R$ %s\n",
            cliente.getNome(), agencia, numero, String.format("%.2f", saldo).replace(".", ",") );
    };

    
}
