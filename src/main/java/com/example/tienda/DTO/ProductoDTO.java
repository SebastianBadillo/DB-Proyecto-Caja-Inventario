package com.example.tienda.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO implements Serializable {

    private static final long serialVersionUID = -8897880147341796299L;
    private Long id;
    private String nombre;
    private String empresa;
    private Long codigo;
    private String descripcion;
    private Long precio;

}
