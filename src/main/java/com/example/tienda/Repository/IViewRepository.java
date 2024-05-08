package com.example.tienda.Repository;

import com.example.tienda.Model.ViewGeneral;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IViewRepository extends JpaRepository<ViewGeneral, Long> {
    @Query(value = "SELECT * FROM vista_inventario_producto_general", nativeQuery = true)
    List<Object> obtenervistaGeneral();

    @Query(value= "SELECT * FROM vista_inventario_producto_general where nombre LIKE  %:nombre%", nativeQuery = true)
    List<Object> obtenerVistaGeneralByNombre(@Param("nombre") String nombre);


    @Query(value = "SELECT * FROM vista_inventario_producto_especifica where codigo = :codigo", nativeQuery = true)
    List<Object> obtenervistaEspecifica(@Param("codigo") int codigo);

    @Query(value= "SELECT * FROM vista_inventario_producto_especifica where nombre LIKE  %:nombre%", nativeQuery = true)
    List<Object> obtenerVistaEspecificalByNombre(@Param("nombre") String nombre);
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE productos  SET nombre = ?1, codigo = ?2, precio = ?4 where id = ?3", nativeQuery = true)
    void setProductInfoById(String nombre, Long codigo, Long id, Long precio);

    @Modifying
    @Query(value = "UPDATE inventario i SET i.cantidad = ?1, i.fechain = ?2, i.fechaven = ?3, i.lote = ?4 WHERE i.id = ?5", nativeQuery = true)
    void setInvInfoById(Long cantidad, Date fechain, Date fechaven, String lote, Long idInv);
}

