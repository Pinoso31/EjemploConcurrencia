package com.example.ejemploconcurrencia;

public class Caja {

    private int cantidadVentas = 0;
    private int totalRecaudado = 0;

    /**
     * Syncronized  permite que splamente un thread ( hilo ) ejecute un metodo a la vez
     * con esto avisamos el problema de race condtion
     * @param vendedor el problema de race condition
     * @param monto monto asignado
     */
    public synchronized void registrarVentas(String vendedor, int monto) {
        cantidadVentas++;
        totalRecaudado += monto;
        System.out.println(vendedor + "registro una venta de C$ " + monto + " | ventas acumuladas : "
                + cantidadVentas + " | total : C$" + totalRecaudado);

    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getTotalRecaudado() {
        return totalRecaudado;
    }
}
