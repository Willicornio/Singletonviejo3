package eetac;

public class Producto {
    int precio;
    String idProducto;
    int ventas;

    public Producto(int precio, String idProducto, int ventas) {
        this.precio = precio;
        this.idProducto = idProducto;
        this.ventas = ventas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
