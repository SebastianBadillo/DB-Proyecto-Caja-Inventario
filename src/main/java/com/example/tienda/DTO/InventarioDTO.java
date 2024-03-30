package com.example.tienda.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class InventarioDTO implements Serializable {

    private static final long serialVersionUID = 1647072313209565787L;
    private Long id;


    private Long idProducto;

    private Long cantidad;
}
