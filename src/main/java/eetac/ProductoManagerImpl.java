package eetac;
import org.apache.log4j.Logger;



import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class ProductoManagerImpl implements ProductoManager {

    final static Logger log = Logger.getLogger(ProductoManagerImpl.class.getName());
    public static ProductoManager pm;

    private HashMap<String, Usuario> usuarios;
    private LinkedList<Producto> productos;
    private LinkedList<Caja> cajas;
    private LinkedList<Pedido> pedidos;
    private LinkedList<Pedido> pedidosrealidos;


    public ProductoManagerImpl() {

        pedidos = new LinkedList<Pedido>();
        cajas = new LinkedList<Caja>();
        productos = new LinkedList<Producto>();
        usuarios = new HashMap<String, Usuario>();
        pedidosrealidos = new LinkedList<Pedido>();
    }

    public static ProductoManager getInstance() {

        if (pm == null) pm = new ProductoManagerImpl();

        return pm;

    }


    public void addCaja(Producto p, int cantidad, String idPedido) {
        log.info("Añadiendo caja");

        Producto producto = p;
        Pedido pedido = null;
        Caja caja = new Caja(15, p, idPedido);
        this.cajas.add(caja);


    }

    public int dameNumeroCajas() {
        return this.cajas.size();
    }

    public void addUser(String idUser) {
        log.info("Añadiendo Usuario");
        this.usuarios.put(idUser, new Usuario(idUser));
    }

    public void addProducto(String idProdocto, int precio, int ventas) {
        log.info("Añadiendo Producto");

        Producto producto = new Producto(precio, idProdocto, ventas);
        productos.add(producto);

    }

    public LinkedList<Producto> listaProductoPrecio() {
        LinkedList<Producto> lista = new LinkedList<Producto>(this.productos);
        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return (int) (o1.getPrecio() - o2.getPrecio());
            }
        });
        return lista;


    }

    public int numeroCajas() {
        return this.cajas.size();
    }


    public void hacerPedido(String idUser, String idPedido) throws UsuarioNotFound {
        log.info("Hacer pedido");
        Usuario user;
        user = usuarios.get(idUser);
        Pedido pedido = new Pedido(idPedido);
        if (user != null) {

            int i = 0;

            for (i = 0; i < this.cajas.size(); i++) {

                if (idPedido.equals(this.cajas.get(i).getIdPedido())) {
                    Caja caja = this.cajas.get(i);
                    pedido.addProducto(caja);
                }

            }
            user.addPedido(pedido);
            pedidos.add(pedido);
        } else {
            log.error("Usuario");
            throw new UsuarioNotFound();
        }

    }

    public void servirPedido(String idPedido) throws PedidoNotFound {
        log.info("Servir primer pedido");
        Pedido p;
        p = pedidos.getFirst();
        pedidos.poll();
        p.setRealizado(true);
        pedidosrealidos.add(p);

    }
    public int dameNumeroPedidoRealizado(){
        return this.pedidosrealidos.size();
    }



    public LinkedList<Producto> listaProductosVenta() {
        LinkedList<Producto> listaProductos = new LinkedList<Producto>(this.productos);
        Collections.sort(listaProductos, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return (int) (-1) * (o1.getVentas() - o2.getVentas());
            }
        });
        return listaProductos;


    }

    public LinkedList<Pedido> listaPedidosUser(String idUser) throws UsuarioNotFound {
        Usuario u = usuarios.get(idUser);
        LinkedList<Pedido> listaPedidos = new LinkedList<Pedido>();

        if (u != null) {

            listaPedidos = u.getListaPedidos();
            return listaPedidos;

        } else {
            log.error("Usuario no encontrado");
        }
        throw new UsuarioNotFound();
    }


    public void clear() {

        usuarios.clear();
        pedidos.clear();
        ;
        productos.clear();
        ;
        cajas.clear();
        ;

    }

    public int dameNumeroProductos() {
        LinkedList<Producto> lista = new LinkedList<Producto>(this.productos);
        int num = lista.size();
        return num;
    }

    public int dameNumeroUsuarios() {
        return this.usuarios.size();
    }


    public int dameListaCajasenPedido(String idPedido) {
        int i = 0;
        int resulado = 0;

        for (i = 0; i < this.pedidos.size(); i++) {

            if (idPedido.equals(this.pedidos.get(i).getIdPedido())) {
                Pedido pedido = this.pedidos.get(i);
                resulado = pedido.getProductos().size();

            }


        }
        return resulado;
    }

        public int dameListaPedidoenUsuario (String idUser){
            Usuario user = usuarios.get(idUser);
            return user.listaPedidos.size();
        }
    public int damepedidos(){
        return this.pedidos.size();
    }
}
