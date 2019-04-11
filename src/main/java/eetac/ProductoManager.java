package eetac;

import java.util.LinkedList;

public interface ProductoManager {
    public void addCaja(Producto p, int cantidad, String idPedido);
    public void addUser (String idUser);
    public void addProducto (String idProducto, int precio, int ventas);
    public LinkedList<Producto> listaProductoPrecio();
    public void servirPedido (String idPedido) throws PedidoNotFound;
    public LinkedList<Producto> listaProductosVenta();
    public LinkedList<Pedido> listaPedidosUser (String idUser) throws UsuarioNotFound;
    public void clear ();
    public int dameNumeroProductos();
    public int dameNumeroUsuarios();
    public  int numeroCajas();
    public void hacerPedido (String idUser, String idPedido) throws UsuarioNotFound;
    public int dameNumeroCajas();
    public int damepedidos();
    public int dameListaPedidoenUsuario (String idUser);
    public int dameListaCajasenPedido(String idPedido);
    public int dameNumeroPedidoRealizado();

}
