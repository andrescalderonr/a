package eci.edu.cvds.Parcial2.DTO;

import eci.edu.cvds.Parcial2.model.Articulo;

import java.util.List;


public class PagoDTO {
    private String idUser;
    private List<Articulo> articulos;
    private String fechaCompra;
    public PagoDTO() {}

    public PagoDTO(String idUser, List<Articulo> articulos, String fechaCompra) {
        this.idUser = idUser;
        this.articulos = articulos;
        this.fechaCompra = fechaCompra;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

}

