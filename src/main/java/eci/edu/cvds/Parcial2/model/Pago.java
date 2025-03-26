package eci.edu.cvds.Parcial2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;


@Document (collection = "pagos")
public class Pago {
    @Id
    private String id;

    private String idUser;
    private List<Articulo> articulos;
    private int total;
    private String fechaCompra;
    private String estado;
    private String messgase;
    public Pago() {}

    public Pago( String id, String idUser, List<Articulo> articulos, int total, String fechaCompra, String estado, String messgase) {
        this.id = id;
        this.idUser = idUser;
        this.articulos = articulos;
        this.total = total;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.messgase = messgase;
    }

    public String getId(){ return id; }
    public void setId(String id){ this.id = id;}
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMessgase() {
        return messgase;
    }

    public void setMessgase(String messgase) {
        this.messgase = messgase;
    }

}
