package eetac;

import java.util.LinkedList;

public class Usuario {
    String idUsuario;
    LinkedList<Pedido> listaPedidos;

    public Usuario (String idUsuario){
        this.idUsuario = idUsuario;
        this.listaPedidos = new LinkedList<Pedido>();
    }

    public void addPedido (Pedido p){
        this.listaPedidos.add(p);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LinkedList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(LinkedList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
