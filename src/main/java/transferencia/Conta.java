package transferencia;

public class Conta {
    /*
    agencia, numConta, saldo, proprietario
     */
    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente proprietario;

    public Conta(String agencia, String numeroConta, double saldo, Cliente proprietario){
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.proprietario = proprietario;
    }


    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }
    public boolean realizarSaques(double valor) {
        if (valor > saldo){
            return false;
        }
        saldo -=valor;
        return true;
    }
    public void realizarDeposito(double valor) {
        saldo = saldo + valor;
    }
    public boolean realizarTransferencia(double valor, Conta destino) {
        if (realizarSaques(valor)){
         destino.realizarDeposito(valor);
         return true;
        }
        return false;
    }
}
