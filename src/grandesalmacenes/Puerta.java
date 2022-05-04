package grandesalmacenes;

public class Puerta {
	boolean ocupada;

	public Puerta() {
		this.ocupada = false;

	}

	public boolean estaOcupada() { //Indica que la puerta esta con una persona pasando por ella.
		return this.ocupada;
	}

	public synchronized void liberarPuerta() { // La persona ya paso por la puerta y la dejo para que otro ingrese.
		this.ocupada = false;
	}

	public synchronized boolean intentarEntrar() { //Momento en que los clientes pelean por ingresar.
		if (this.ocupada)
			return false;
		/*
		 * Si llegamos aquí, la puerta estaba libre pero la pondremos a ocupada un
		 * tiempo y luego la volveremos a poner a "libre"
		 */
		this.ocupada = true;
		return true;
	}
}
