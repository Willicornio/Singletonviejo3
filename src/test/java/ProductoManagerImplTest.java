import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import eetac.*;

public class ProductoManagerImplTest
{
final static Logger log = Logger.getLogger(ProductoManagerImplTest.class.getName());

ProductoManager pm;

@Before


    public void setUp(){

    pm = ProductoManagerImpl.getInstance();
    this.pm = new ProductoManagerImpl();
    log.info("Before");

}


@Test
public void testAddProducto(){
    this.pm.addProducto("hola", 15, 10);
    Assert.assertEquals(1, this.pm.dameNumeroProductos());
}

@Test
public void testAddUsuario(){

    this.pm.addUser("Willi");
    Assert.assertEquals(1,this.pm.dameNumeroUsuarios());
}

@Test
public void testDameListaOrdenadoProductoPrecio() {

    this.pm.addProducto("tomate", 1000, 15);
    this.pm.addProducto("salsa", 10, 15);
    this.pm.addProducto("azucar", 11, 15);

    Assert.assertEquals(10, pm.listaProductoPrecio().get(0).getPrecio());
    Assert.assertEquals(11, pm.listaProductoPrecio().get(1).getPrecio());
    Assert.assertEquals(1000, pm.listaProductoPrecio().get(2).getPrecio());

}
@Test
        public void testAddCaja() throws UsuarioNotFound {

    this.pm.addUser("User1");
    Producto producto1 = new Producto(15, "toamte", 28);
    Producto producto3 = new Producto(15, "toamte", 28);
    Producto producto2 = new Producto(15, "toamte", 28);
    this.pm.addCaja(producto1, 10, "pedido1");
    this.pm.addCaja(producto3, 10, "pedido1");
    this.pm.addCaja(producto2, 10, "pedido2");

    Assert.assertEquals(3, pm.dameNumeroCajas());


    }


    @Test
    public void testHacerPedido() throws UsuarioNotFound{
        this.pm.addUser("User1");
        Producto producto1 = new Producto(15, "toamte", 28);
        Producto producto3 = new Producto(15, "toamte", 28);
        Producto producto2 = new Producto(15, "toamte", 28);
        this.pm.addCaja(producto1, 10, "pedido1");
        this.pm.addCaja(producto3, 10, "pedido1");
        this.pm.addCaja(producto2, 10, "pedido2");

        this.pm.hacerPedido("User1","pedido1");

        Assert.assertEquals(1,this.pm.damepedidos());
        Assert.assertEquals(1,this.pm.dameListaPedidoenUsuario("User1"));
        Assert.assertEquals(2,this.pm.dameListaCajasenPedido("pedido1"));


    }





@After
    public void setDown(){

    pm.clear();
}
}
