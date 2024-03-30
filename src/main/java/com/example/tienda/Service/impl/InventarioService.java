package com.example.tienda.Service.impl;

import com.example.tienda.DTO.InventarioDTO;
import com.example.tienda.Model.Inventario;
import com.example.tienda.Repository.IInventarioRepository;
import com.example.tienda.Service.interfaces.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IInventarioService {
    private IInventarioRepository iInventarioRepository;

    @Override
    public Inventario addInventario(InventarioDTO inventarioDto) {
        Inventario inventario = new Inventario();
        inventario.setId(inventarioDto.getId());
        inventario.setIdProducto(inventarioDto.getIdProducto());
        inventario.setCantidad(inventarioDto.getCantidad());
        return this.iInventarioRepository.save(inventario);
    }

    @Override
    public Boolean deleteInventario(Long Id) {
        this.iInventarioRepository.deleteById(Id);
        return true;
    }

    @Override
    public Inventario getInventario(Long Id) {
        return this.iInventarioRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Inventario> getAllInventario() {
        return this.iInventarioRepository.findAll();
    }

    @Autowired
    public void setiInventarioRepository(IInventarioRepository iInventarioRepository){
        this.iInventarioRepository = iInventarioRepository;
    }

}
