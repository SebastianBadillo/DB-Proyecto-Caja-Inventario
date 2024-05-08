package com.example.tienda.Service.interfaces;

import com.example.tienda.DTO.ProductoDTO;
import com.example.tienda.Model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {
    Producto addProducto(ProductoDTO productoDto);

    Boolean deleteProducto(Long Id);

    Producto getProducto(Long Id);

    List<Producto> getAllProductos();
    List<Producto> findByNombreContainingIgnoreCase(String nombre);


}


