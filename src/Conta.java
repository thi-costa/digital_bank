public abstract class Conta implements IConta {
    private final static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected Double saldo;
    protected Cliente cliente;
    protected String tipoDeConta;

    public Conta(Cliente cliente, String tipoDeConta){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoDeConta = tipoDeConta;
        this.saldo = 0.0;
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
    public int getClienteId() {
        return cliente.getId();
    }


    @Override
    public void sacar(Double valor) {
        saldo -= valor;        
    }


    @Override
    public void depositar(Double valor) {
        saldo += valor; 
    }


    @Override
    public void transferir(Double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInformacoesConta() {
        System.out.printf("=== Extrato Conta %s ===\n", tipoDeConta);
        System.out.printf("Titular: %s\nAgencia: %d\nNúmero: %d\nSaldo: R$ %s\n",
            cliente.getNome(), agencia, numero, String.format("%.2f", saldo).replace(".", ",") );
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    };

    
}
