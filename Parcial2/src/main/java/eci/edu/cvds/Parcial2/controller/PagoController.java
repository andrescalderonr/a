package eci.edu.cvds.Parcial2.controller;

import eci.edu.cvds.Parcial2.DTO.PagoDTO;
import eci.edu.cvds.Parcial2.model.Pago;
import eci.edu.cvds.Parcial2.service.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
    @Autowired
    private PagoServicio pagoServicio;
    @PostMapping
    public Pago resgistrar (@RequestBody PagoDTO pagosDTO){
        return pagoServicio.registrarPago(pagosDTO);
    }
    @GetMapping
    public List<Pago> obtenerPagos (@PathVariable String idUser){
        return pagoServicio.obtenerPagosPorUsuario(idUser);
    }
}