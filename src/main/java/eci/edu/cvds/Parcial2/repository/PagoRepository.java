package eci.edu.cvds.Parcial2.repository;

import eci.edu.cvds.Parcial2.model.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface PagoRepository extends MongoRepository<Pago,String> {
    List<Pago> findByIdUser (String idUser);
}


