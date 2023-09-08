package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
    private ArrayList<String> agregados;
    private ArrayList<String> elminados;
    private ProductoMenu baseb;

    public ProductoAjustado(ProductoMenu base) {
        this.baseb = base;
        elminados = new ArrayList<>();
        agregados = new ArrayList<>();
    }

    public String getNombre() {

    }

    public int getPrecio() {
        return 0;

    }

    public String generarTextoFactura() {
        return null;

    }

}
