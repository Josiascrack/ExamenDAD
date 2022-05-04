package grandesalmacenes;

public class GrandesAlmacenes {
	public static void main(String[] args) throws InterruptedException {
		final int NUM_CLIENTES = 300;
		final int NUM_PRODUCTOS = 100;

		Cliente[] cliente = new Cliente[NUM_CLIENTES];
		Almacen almacen = new Almacen(NUM_PRODUCTOS);
		Puerta puerta = new Puerta();

		Thread[] hilosAsociados = new Thread[NUM_CLIENTES];//MISMA CANTIDAD DE CLIENTES QUE TENGA MISMA CANTIDAD DE ARRAY DE HILOS.

		for (int i = 0; i < NUM_CLIENTES; i++) {
			String nombreHilo = "Cliente " + i;
			cliente[i] = new Cliente(puerta, almacen, nombreHilo);//INSTANCIO UN CLIENTE 
			hilosAsociados[i] = new Thread(cliente[i]);//INSTANCIO UN HILO CON EL CLIENTE
			// Intentamos arrancar el hilo
			hilosAsociados[i].start();
		} // Fin del for

		// Una vez arrancados esperamos a que todos terminen
		for (int i = 0; i < NUM_CLIENTES; i++) {
			hilosAsociados[i].join();//UNO TODOS SE EJECUTEN A LA VEZ
		} // Fin del for
	}
}
