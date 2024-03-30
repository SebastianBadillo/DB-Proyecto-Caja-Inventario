package com.example.tienda.Service.impl;

import com.example.tienda.DTO.ProductoDTO;
import com.example.tienda.Model.Producto;
import com.example.tienda.Repository.IProductoRepository;
import com.example.tienda.Service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    private IProductoRepository iProductoRepository;
    @Override
    public Producto addProducto(ProductoDTO productoDto) {
        Producto producto = new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setEmpresa(productoDto.getEmpresa());
        producto.setCodigo(productoDto.getCodigo());
        producto.setFechaIn(productoDto.getFechaIn());
        producto.setFechaVen(productoDto.getFechaVen());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        return this.iProductoRepository.save(producto);
    }

    @Override
    public Boolean deleteProducto(Long Id) {
        this.iProductoRepository.deleteById(Id);
        return true;
    }

    @Override
    public Producto getProducto(Long Id) {
        return this.iProductoRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Producto> getAllProductos() {
        return this.iProductoRepository.findAll();
    }

    @Override
    public List<Producto> findByNombreContainingIgnoreCase(String nombre) {
        String nombreNormalizado = nombre.trim().toLowerCase();
        return this.iProductoRepository.findByNombreContainingIgnoreCase(nombreNormalizado);
    }

    @Autowired
    public void setiProductoRepository(IProductoRepository iproductoRepository) {
        this.iProductoRepository = iproductoRepository;
    }
}
