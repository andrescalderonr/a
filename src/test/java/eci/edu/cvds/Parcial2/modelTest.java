package eci.edu.cvds.Parcial2;

import eci.edu.cvds.Parcial2.DTO.PagoDTO;
import eci.edu.cvds.Parcial2.model.Articulo;
import eci.edu.cvds.Parcial2.model.Pago;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest

public class modelTest {
    @Test
    void testYGettersPago() {
        Articulo articulo = new Articulo("Producto A", 2, 100);
        Pago pago = new Pago("1", "user1", List.of(articulo), 200, "2025-03-26", "Aprobado", "Se aprobo la compra");
        assertEquals("1", pago.getId());
        assertEquals("user1", pago.getIdUser());
        assertEquals(200, pago.getTotal());
        assertEquals("2025-03-26", pago.getFechaCompra());
        assertEquals("Aprobado", pago.getEstado());
        assertEquals("Se aprobo la compra", pago.getMessgase());
    }

    @Test
    void testConstructorArticuloAndPago() {
        Articulo articulo = new Articulo("Producto A", 2, 100);
        Pago pago = new Pago("1", "user1", List.of(articulo), 200, "2025-03-26", "Rechazado", "Se rechazo la compra, falta información");
        assertEquals("Producto A", articulo.getNombre());
        assertEquals(2, articulo.getCantidad());
        assertEquals(100, articulo.getPrecioTotal());
    }

    @Test
    void testSettersPagoYArticulo() {
        Articulo articulo = new Articulo();
        Pago pago = new Pago();
        articulo.setNombre("Producto B");
        articulo.setCantidad(5);
        articulo.setPrecioTotal(200);

        pago.setId("2");
        pago.setIdUser("user2");
        pago.setArticulos(List.of(articulo));
        pago.setTotal(1000);
        pago.setFechaCompra("2026-04-15");
        pago.setEstado("Aprobado");
        pago.setMessgase("Se aprobo la compra");

        assertEquals("Producto B", articulo.getNombre());
        assertEquals(5, articulo.getCantidad());
        assertEquals(200, articulo.getPrecioTotal());

        assertEquals("2", pago.getId());
        assertEquals("user2", pago.getIdUser());
        assertEquals(List.of(articulo), pago.getArticulos());
        assertEquals(1000, pago.getTotal());
        assertEquals("2026-04-15", pago.getFechaCompra());
        assertEquals("Aprobado", pago.getEstado());
        assertEquals("Se aprobo la compra", pago.getMessgase());
    }

    @Test
    void constructorPagoDTO(){
        Articulo articulo = new Articulo("Producto A", 2, 100);
        PagoDTO pagoDTO = new PagoDTO("user2",List.of(articulo),"2026-04-15");

        assertEquals("user2", pagoDTO.getIdUser());
        assertEquals(List.of(articulo), pagoDTO.getArticulos());
        assertEquals("2026-04-15", pagoDTO.getFechaCompra());

    }
    @Test
    void testSettersGettersPagoDTO() {
        PagoDTO pagoDTO = new PagoDTO();
        Articulo articulo = new Articulo();

        articulo.setNombre("Producto B");
        articulo.setCantidad(5);
        articulo.setPrecioTotal(200);

        pagoDTO.setIdUser("user2");
        pagoDTO.setArticulos(List.of(articulo));
        pagoDTO.setFechaCompra("2026-04-15");

        assertEquals("user2", pagoDTO.getIdUser());
        assertEquals(List.of(articulo), pagoDTO.getArticulos());
        assertEquals("2026-04-15", pagoDTO.getFechaCompra());
    }
}
