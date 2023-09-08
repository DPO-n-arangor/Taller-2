package modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<String> itemsPedido;
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;

    public Pedido(String nombreCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        itemsPedido = new ArrayList<>();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void agregarProducto(Producto nuevoItem) {
        // TODO
    }

    private int getPrecioNetoPedido() {
        // TODO
        return 0;
    }

    private int getPrecioTotalPedido() {
        // TODO
        return 0;
    }

    private int getPrecioIvaPedido() {
        // TODO
        return 0;
    }

    private String generarTextoFactura() {
        // TODO
        return "";
    }

    public void guardarFactura(File archivo) {
        // TODO
        // guardar pedido en la capeta data
    }

}
