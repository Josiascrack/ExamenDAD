package productoresyconsumidores;

public class Consumidor implements Runnable{
	 Cola colaCompartida;
     public Consumidor(Cola cola){
             this.colaCompartida=cola;
     }
     @Override
     public void run() {
             int num;
             while (true){
                     num=colaCompartida.desencolar();
                     if (num!=-1){
                             System.out.println("Consumidor recuperó el numero:"+num); //indica que agarro un numero es sua accion
                     } /* Fin del if*/
             } /*Fin del bucle infinito*/
     } /* Fin del run()*/
}
