package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
    private HashMap<String, Ingrediente> ingredientes;
    private HashMap<String, ProductoMenu> menuBase;
    private HashMap<String, Combo> combos;
    private ArrayList<String> pedidos;
    private double descuentos;

    public Restaurante() {
        ingredientes = new HashMap<>();
        menuBase = new HashMap<>();
        combos = new HashMap<>();
        pedidos = new ArrayList<>();

    }

    public void iniciarPedido(String nombreCliente, String direccionCliente) {
    	//TODO

    }

    public void cerrarYGuardarPedido() {
    	//TODO

    }

    public Pedido getPedidoEnCurso() {
    	//TODO
        return null;

    }

    public ArrayList<Producto> getMenuBase() {
    	//TODO
        return null;

    }

    public ArrayList<Ingrediente> getIngredientes() {
    	//TODO
        return null;
    }

    public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
        try {
            // cargar tres archivos siendo ingredientes.txt, menu.txt y combos.txt
            cargarIngredientes(archivoIngredientes);
            cargarMenu(archivoMenu);
            cargarCombos(archivoCombos);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void cargarIngredientes(File archivoIngredientes) {

        try (BufferedReader lector = new BufferedReader(new FileReader((archivoIngredientes)))) {
            String linea = lector.readLine();

            while (linea != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String costoString = datos[1].trim();
                int costo = Integer.parseInt(costoString);
                Ingrediente ingrediente0 = new Ingrediente(nombre, costo);
                ingredientes.put(nombre, ingrediente0);
                linea = lector.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarMenu(File archivoMenu) {
        try {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoMenu))) {
                String linea = lector.readLine();

                while (linea != null) {
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    String precioString = datos[1].trim();
                    int precioBase = Integer.parseInt(precioString);
                    ProductoMenu precio = new ProductoMenu(nombre, precioBase);
                    menuBase.put(nombre, precio);
                    linea = lector.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarCombos(File archivoCombos) {
        try {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoCombos))) {
                String linea = lector.readLine();

                while (linea != null) {
                    String[] datos = linea.split(";");
                    String nombre = datos[0].trim();
                    String descuentoString = datos[1].replace("%", "");
                    int descuentoDouble = Integer.parseInt(descuentoString);
                    Combo combitos = new Combo(nombre, descuentoDouble);
                    combos.put(nombre, combitos);
                    linea = lector.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
