package eetac;

import java.net.PortUnreachableException;
import java.util.LinkedList;

public class Pedido {
    LinkedList<Caja> cajas;
    boolean realizado;
    String idPedido;
    int numeroPedido;

    public Pedido (String idPedido, LinkedList<Caja> productoList, int numeroPedido){

        this.idPedido = idPedido;
        this.cajas = productoList;
        this.realizado = false;
        this.numeroPedido= numeroPedido;
    }

    public Pedido (String idPedido){

        this.idPedido = idPedido;
        this.cajas = new LinkedList<Caja>();
        this.realizado = false;
        this.numeroPedido = numeroPedido;
    }

   public void addProducto(Caja p){
        this.cajas.add(p);
   }

    public LinkedList<Caja> getProductos() {
        return cajas;
    }

    public void setProductos(LinkedList<Caja> productos) {
        this.cajas = productos;
    }

    public boolean isRealizado() {
            return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;

    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
}
