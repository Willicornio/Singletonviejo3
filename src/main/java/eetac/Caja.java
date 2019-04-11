package eetac;

public class Caja {
    int cantidad;
    Producto p;
    String idPedido;

    public Caja(int cantidad, Producto p,String idPedido) {
        this.cantidad = cantidad;
        this.p = p;
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
}
