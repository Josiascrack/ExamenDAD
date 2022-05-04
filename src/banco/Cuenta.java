package banco;

public class Cuenta {
	 private int saldo;
	    private int saldoInicial;

	    public Cuenta(int saldo){
	        this.saldoInicial=saldo;
	        this.saldo=saldo;
	    }
	    public synchronized void hacerMovimiento(int cantidad){
	        this.saldo = this.saldo+cantidad;
	    }
	    public boolean esSimulacionCorrecta(){
	        if (this.saldo==this.saldoInicial) return true; //Aqui entendemos que el mismo saldo es el saldo incial debido al Retiro e Ingreso
	        return false;
	    }
	    public int getSaldo(){
	        return this.saldo;
	    }
}
