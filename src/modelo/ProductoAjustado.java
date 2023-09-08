package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
    private ArrayList<String> agregados;
    private ArrayList<String> elminados;
    private ProductoMenu base1;

    public ProductoAjustado(ProductoMenu base) {
        this.base1 = base;
        elminados = new ArrayList<>();
        agregados = new ArrayList<>();
    }

    public String getNombre() {
        // TODO
        return null;
    }

    public int getPrecio() {
        // TODO
        return 0;

    }

    public String generarTextoFactura() {
        // TODO
        return null;

    }

}
