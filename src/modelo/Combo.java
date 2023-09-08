package modelo;

import java.util.ArrayList;

public class Combo implements Producto {
    private double descuento;
    private String nombreCombo;
    private ArrayList<ProductoMenu> itemsCombo;

    public Combo(String nombreCombo, double descuento) {
        this.nombreCombo = nombreCombo;
        this.descuento = descuento;
        itemsCombo = new ArrayList<>();
    }

    public void agregarItemACombo(Producto itemCombo) {
        itemsCombo.add((ProductoMenu) itemCombo);
    }

    public int getPrecio() {
        int suma = 0;
        for (ProductoMenu i : itemsCombo) {
            suma += i.getPrecio();
        }
        int precioCombo = (int) (suma * (descuento / 100));
        return precioCombo;

    }

    public String generarTextoFactura() {
        return "";
    }

    public String getNombre() {
        return nombreCombo;
    }

}
