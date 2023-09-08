package modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<String> itemsPedido = new ArrayList<>();
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;

    public Pedido(String nombreCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void agregarProducto(Producto nuevoItem) {

    }

    private int getPrecioNetoPedido() {
        return 0;
    }

    private int getPrecioTotalPedido() {
        return 0;
    }

    private int getPrecioIvaPedido() {
        return 0;
    }

    private String generarTextoFactura() {
        return "";
    }

    public void guardarFactura(File archivo) {
        // guardar pedido en la capeta data
    }

}
