package eci.edu.cvds.Parcial2;


import eci.edu.cvds.Parcial2.DTO.PagoDTO;
import eci.edu.cvds.Parcial2.controller.PagoController;
import eci.edu.cvds.Parcial2.model.Articulo;
import eci.edu.cvds.Parcial2.model.Pago;
import eci.edu.cvds.Parcial2.service.PagoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.List;

@ExtendWith(MockitoExtension.class)
public class controllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private PagoController controller;

    @Mock
    private PagoServicio pagoServicio;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void registrarPago_ShouldReturnPago_WhenValidRequest() {
        Articulo articulo = new Articulo("Producto y", 2, 100);
        PagoDTO pagoDTO = new PagoDTO("user1", List.of(articulo), "2025-03-26");
        Pago pagoEsperado = new Pago("1", "user1", List.of(articulo), 200, "2025-03-26", "Aprobado", "Se aprobo la compra");

        when(pagoServicio.registrarPago(pagoDTO)).thenReturn(pagoEsperado);

        Pago response = controller.resgistrar(pagoDTO);

        assertNotNull(response);
        assertEquals("1", response.getId());
        assertEquals("user1", response.getIdUser());
        assertEquals(200, response.getTotal());
        assertEquals("Aprobado", response.getEstado());
        assertEquals("Se aprobo la compra", response.getMessgase());

        verify(pagoServicio, times(1)).registrarPago(pagoDTO);
    }

    @Test
    void obtenerPagos_ShouldReturnListaDePagos_CuandoExistenPagos() {
        String idUser = "user1";
        Articulo articulo = new Articulo("Producto X", 2, 100);
        List<Pago> pagosEsperados = List.of(
                new Pago("1", idUser, List.of(articulo), 200, "2025-03-26", "Aprobado", "Compra exitosa"),
                new Pago("2", idUser, List.of(articulo), 300, "2025-03-27", "Rechazado", "Se rechazo la compra, falta información")
        );

        when(pagoServicio.obtenerPagosPorUsuario(idUser)).thenReturn(pagosEsperados);

        List<Pago> response = controller.obtenerPagos(idUser);

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("1", response.get(0).getId());
        assertEquals("2", response.get(1).getId());
        assertEquals(200, response.get(0).getTotal());
        assertEquals(300, response.get(1).getTotal());

        verify(pagoServicio, times(1)).obtenerPagosPorUsuario(idUser);
    }
}
