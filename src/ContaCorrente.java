public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente, String tipoDeConta){
        super(cliente, tipoDeConta);
    }

    @Override
    public void imprimirExtrato(){
        imprimirInformacoesConta();
    };
    
}
