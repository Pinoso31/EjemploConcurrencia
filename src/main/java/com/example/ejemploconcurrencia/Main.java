package com.example.ejemploconcurrencia;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Objeto compartido por todos los Trheads ( hilos )
        Caja caja = new Caja();

        //Runnable representa la tarea que ejecutara cada uno de los vendedores
        Runnable vendedor1 = () -> procesarVentas("Vendedor 1 ", caja);
        Runnable vendedor2 = () -> procesarVentas("Vendedor 2 ", caja);
        Runnable vendedor3 = () -> procesarVentas("Vendedor 3 ", caja);

        //Crear los Threads
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("---- Inicio del proceso de ventas ----");

        /**
         * Start() es el encargado de iniciar el proceso de hilo
         * los tres vendedores comienzan a procesar sus ventas concurentemente
         */
        hilo1.start();
        hilo2.start();
        hilo3.start();

        /**
         * Join() permite que el hilo main espere el proceso
         * hasta que terminen los otros threads
         */
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("---- Fin del proceso de ventas ----");
        System.out.println("Cantidad de ventas : " + caja.getCantidadVentas());
        System.out.println("Total recaudado : " + caja.getTotalRecaudado());
    }

    private static void procesarVentas(String vendedor, Caja caja) {
        //simulando 5 ventas
        for ( int i = 1; i <= 5; i++){
            try{
                Thread.sleep(200);
                caja.registrarVentas(vendedor, 5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(vendedor + "Fue interrumpido");
                return;
            }

        }
    }
}
