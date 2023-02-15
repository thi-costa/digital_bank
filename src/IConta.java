public interface IConta {
    public void sacar(Double valor);
    public void depositar(Double valor);
    public void transferir(Double valor, IConta contaDestino);
    public void imprimirExtrato();
}
