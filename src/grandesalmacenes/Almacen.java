package grandesalmacenes;

public class Almacen {
	private int numProductos;

	public Almacen(int nProductos) {
		this.numProductos = nProductos;
	}

	public boolean cogerProducto() {
		if (this.numProductos > 0) { //condicion de reduccion del producto por persona que lo obtenga.
			this.numProductos--;
			return true;
		}
		return false;
	}
}
