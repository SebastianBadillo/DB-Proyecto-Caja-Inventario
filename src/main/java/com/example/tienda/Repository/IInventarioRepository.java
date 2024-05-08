package com.example.tienda.Repository;

import com.example.tienda.Model.Inventario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepository extends JpaRepository<Inventario, Long> {
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE inventario  SET cantidad = ?1 where id = ?2", nativeQuery = true)
    void updateInventory(Long Cantidad, Long id);
}
