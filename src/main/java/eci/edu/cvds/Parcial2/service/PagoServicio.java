package eci.edu.cvds.Parcial2.service;

import eci.edu.cvds.Parcial2.DTO.PagoDTO;
import eci.edu.cvds.Parcial2.model.Pago;
import eci.edu.cvds.Parcial2.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServicio {
    @Autowired
    private PagoRepository pagoRepository;
    public Pago registrarPago(PagoDTO pagosDTO) {

        if (pagosDTO.getIdUser() == null || pagosDTO.getFechaCompra() == null || pagosDTO.getArticulos().isEmpty()) {
            Pago pago = new Pago();
            pago.setIdUser(pagosDTO.getIdUser());
            pago.setArticulos(pagosDTO.getArticulos());
            pago.setTotal(0);
            pago.setFechaCompra(pagosDTO.getFechaCompra());
            pago.setEstado("Rechazado");
            pago.setMessgase("Se rechazo la compra, falta información");

            return pagoRepository.save(pago);
        } else {
            int totalPago = (int) pagosDTO.getArticulos().stream().mapToDouble(a -> a.getPrecioTotal() * a.getCantidad()).sum();
            Pago pagos = new Pago();
            pagos.setIdUser(pagosDTO.getIdUser());
            pagos.setArticulos(pagosDTO.getArticulos());
            pagos.setTotal(totalPago);
            pagos.setFechaCompra(pagosDTO.getFechaCompra());
            pagos.setEstado("Aprovado");
            pagos.setMessgase("Se aprovo la compra");
            return pagoRepository.save(pagos);
        }
    }

    public List<Pago> obtenerPagosPorUsuario (String idUser){
        return pagoRepository.findByIdUser(idUser);
    }
}
