package grandesalmacenes;

import java.util.Random;

public class Cliente implements Runnable {

	Puerta puerta;
	Almacen almacen;
	String nombre;
	Random generador;
	final int MAX_INTENTOS = 10;

	public Cliente(Puerta p, Almacen a, String nombre) {
		this.puerta = p;
		this.almacen = a;
		this.nombre = nombre;
		generador = new Random();
	}

	public void esperar() { // funcion que permitira dar un intervlaod de tiempo a las acciones del cliente
		try {
			int ms_azar = generador.nextInt(1000);
			Thread.sleep(ms_azar);
		} catch (InterruptedException ex) {  //intento por clientes (1 al 300)
			System.out.println("Falló la espera");
		}
	}

	@Override
	public void run() {
		// En esta funcion se demostrara las acciones del cliente al momento en que circustancia se encuetra la puerta
		for (int i = 0; i < MAX_INTENTOS; i++) {
			if (!puerta.estaOcupada()) {           //cliente ingresa y esta pasando por la puerta
				if (puerta.intentarEntrar()) {  //tanteo de los clientes por ser el proximo en ingresar
					esperar(); //tiempo de espera del intervalo
					puerta.liberarPuerta();  //el cliente ya paso otro mas ingresara
					if (almacen.cogerProducto()) { 
						System.out.println(this.nombre + ": cogí un producto!"); //el cliente que agarro un producto
					} else {
						System.out.println(this.nombre + ": ops, crucé pero no cogí nada"); //el cliente que no agarro nada
						return;
					} // Fin del else
				} // Fin del if
			} else {
				esperar();
			}

		} // Fin del for
			// Se superó el máximo de reintentos y abandonamos
		System.out.println(this.nombre + ": lo intenté muchas veces y no pude"); //se arto de los intentos de pdoer ingresar y se retiro
	}

}
