package eci.edu.cvds.Parcial2;

import eci.edu.cvds.Parcial2.model.Articulo;
import eci.edu.cvds.Parcial2.model.Pago;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Parcial2ApplicationTests {

    @Test
    void testSettersYGettersPago() {
        Articulo articulo = new Articulo("Producto A", 2, 100);
        Pago pago = new Pago("1", "user1", List.of(articulo), 200, "2025-03-26", "Aprobado", "Compra exitosa");



        assertEquals("1", pago.getId());
        assertEquals("user1", pago.getIdUser());
        assertEquals(200, pago.getTotal());
        assertEquals("2025-03-26", pago.getFechaCompra());
        assertEquals("Aprobado", pago.getEstado());
        assertEquals("Compra exitosa", pago.getMessgase());
    }

    @Test
    void testSettersYGettersArticulo() {
        Articulo articulo = new Articulo("Producto A", 2, 100);
        Pago pago = new Pago("1", "user1", List.of(articulo), 200, "2025-03-26", "Pendiente", "Pago exitoso");
        assertEquals("Producto A", articulo.getNombre());
        assertEquals(2, articulo.getCantidad());
        assertEquals(100, articulo.getPrecioTotal());


    }




}
