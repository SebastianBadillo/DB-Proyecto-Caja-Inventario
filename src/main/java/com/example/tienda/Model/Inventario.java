package com.example.tienda.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "inventario")
public class Inventario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* Para que sea autoincrement*/
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCTO ID")
    private Long idProducto;

    @Column(name = "LOTE")
    private String lote;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    @Column(name="FECHAIN")
    private  Date fechaIn;

    @Column(name = "FECHAVEN")
    private Date fechaVen;




    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "PRODUCTO ID", insertable = false, updatable = false)
    private Producto producto;

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", idProducto=" + idProducto +
                ", lote=" + lote +
                ", cantidad=" + cantidad +
                ", fechaIn=" + fechaIn +
                ", fechaVen=" + fechaVen +
                ", producto=" + producto +
                '}';
    }
}
