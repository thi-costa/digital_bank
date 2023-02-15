public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, String tipoDeConta){
        super(cliente, tipoDeConta);
    }

    @Override
    public void imprimirExtrato(){
        imprimirInformacoesConta();
    }
}
