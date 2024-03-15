public class Conta {
    private String nomeTitular;
    private int numeroConta;
    private double saldo;

    public Conta(String _nomeTitular, int _numeroConta, double _saldo) {
        this.nomeTitular = _nomeTitular;
        this.numeroConta = _numeroConta;
        this.saldo = _saldo;
    }
    public Conta(int _numeroConta) {
        this.numeroConta = _numeroConta;
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }
    public String setNomeTitular(String novoNomeTitular) {
        if (novoNomeTitular.trim() != "") {
            this.nomeTitular = novoNomeTitular;
            return "Nome alterado!";
        }
        return "Nome não pode ser vazio";
    }
    public int getNumeroConta() {
        return  this.numeroConta;
    }
    public Double getSaldo() {
        return this.saldo;
    }

    public boolean setSaldo(double _saldo) {
        if (_saldo < 0) {
            return false;
        }
        this.saldo = _saldo;
        return true;
    }

    public String depositar (double valor){

        if (valor <= 0) {
            return "Valor do depósito deve ser positivo.";
        }
        this.saldo = this.saldo + valor;
        return "saldo atual " + this.saldo;
    }
    public String sacar (double valor){

        if (valor <= 0) {
            return "Valor do saque deve ser positivo.";
        }
        if(this.saldo >= valor){
            this.saldo -= valor;
            return  "saldo atual " + this.saldo;
        }
        return "Saldo Indisponivel. Saldo Atual " + this.saldo;
    }
}