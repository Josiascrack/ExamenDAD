package productoresyconsumidores;

import java.util.Random;

public class Productor implements Runnable {
	Cola colaCompartida;

	public Productor(Cola cola) {
		this.colaCompartida = cola;
	}

	public void run() {
		Random ra = new Random();

		while (true) {
			int num = ra.nextInt(10);
			while (colaCompartida.encolar(num) == false) { 
				try {
					Thread.sleep(ra.nextInt(3000)); //le agregamos un tiempo para que sus accines de ambos no se trunquen recuerden ls Productores 
					//son dos menos que ls Consumidores 
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Fallo");
				}
			} /* Fin del while */

			System.out.println("Productor encoló el numero:" + num);//indica su accioon que es reponer el numero faltante
		} /* Fin del while externo */
	} /* Fin de run() */
}
