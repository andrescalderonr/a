package eci.edu.cvds.Parcial2;
import eci.edu.cvds.Parcial2.DTO.PagoDTO;
import eci.edu.cvds.Parcial2.model.Articulo;
import eci.edu.cvds.Parcial2.model.Pago;
import eci.edu.cvds.Parcial2.repository.PagoRepository;
import eci.edu.cvds.Parcial2.service.PagoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class pagoServicioTest {
    @InjectMocks
    private PagoServicio pagoServicio;

    @Mock
    private PagoRepository pagoRepository;

    private PagoDTO pagoDTO;
    private Pago pagoEsperado;

    @BeforeEach
    void setUp() {
        Articulo articulo = new Articulo("Producto X", 2, 100);
        pagoDTO = new PagoDTO("user1", List.of(articulo), "2025-03-26");

        pagoEsperado = new Pago("1", "user1", List.of(articulo), 200, "2025-03-26", "Aprobado", "Se aprobo la compra");
    }

    @Test
    void registrarPago_DeberiaGuardarPago_CuandoLosDatosSonValidos() {
        when(pagoRepository.save(any(Pago.class))).thenReturn(pagoEsperado);

        Pago resultado = pagoServicio.registrarPago(pagoDTO);

        assertNotNull(resultado);
        assertEquals("user1", resultado.getIdUser());
        assertEquals(200, resultado.getTotal());
        assertEquals("Aprobado", resultado.getEstado());
        assertEquals("Se aprobo la compra", resultado.getMessgase());

        verify(pagoRepository, times(1)).save(any(Pago.class));
    }

    @Test
    void registrarPago_DeberiaRechazarPago_CuandoFaltaInformacion() {
        PagoDTO pagoDTOIncompleto = new PagoDTO(null, List.of(), null);

        when(pagoRepository.save(any(Pago.class))).thenAnswer(invocation -> {
            Pago pago = invocation.getArgument(0);
            pago.setId("2");
            return pago;
        });

        Pago resultado = pagoServicio.registrarPago(pagoDTOIncompleto);

        assertNotNull(resultado);
        assertEquals("Rechazado", resultado.getEstado());
        assertEquals("Se rechazo la compra, falta información", resultado.getMessgase());

        verify(pagoRepository, times(1)).save(any(Pago.class));
    }

    @Test
    void obtenerPagosPorUsuario_DeberiaRetornarListaDePagos() {
        List<Pago> pagosEsperados = List.of(pagoEsperado);
        when(pagoRepository.findByIdUser("user1")).thenReturn(pagosEsperados);

        List<Pago> resultado = pagoServicio.obtenerPagosPorUsuario("user1");

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("1", resultado.get(0).getId());

        verify(pagoRepository, times(1)).findByIdUser("user1");
    }
}
