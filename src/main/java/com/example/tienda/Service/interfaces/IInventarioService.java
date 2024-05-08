package com.example.tienda.Service.interfaces;

import com.example.tienda.DTO.InventarioDTO;
import com.example.tienda.Model.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInventarioService {
    Inventario addInventario(InventarioDTO inventarioDto);

    Boolean deleteInventario(Long Id);

    Inventario getInventario(Long Id);
    List<Inventario> getAllInventario();

    void updateInventory(Long Cantidad, Long id);
}
