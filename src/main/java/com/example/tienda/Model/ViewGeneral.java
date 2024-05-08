package com.example.tienda.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.io.Serial;


@Entity
@Table(name = "vista_inventario_producto_general")
public class ViewGeneral {

//    @JsonIgnore
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ID")
//    private Long codigo ;
    @Column(name= "NOMBRE")
    private String nombre;

    @Id
    @Column(name= "CODIGO")
    private Long codigo;

    @Column(name= "CANTIDAD_TOTAL")
    private Long cantidadTotal;
}
