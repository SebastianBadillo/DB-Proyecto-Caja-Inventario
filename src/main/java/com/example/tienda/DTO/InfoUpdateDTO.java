package com.example.tienda.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class InfoUpdateDTO {
    private Long inventarioId;
    private long cantidad;
    private Date fechain;
    private Date fechaven;
    private String lote;
    private Long productoId;
    private Long codigo;
    private String nombre;
    private Long precio;

}
