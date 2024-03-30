package com.example.tienda.Controller;

import com.example.tienda.Model.Producto;
import com.example.tienda.Service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto-controller")
@CrossOrigin(origins="http://localhost:4200")
public class ProductoController {
    @Autowired
    private IProductoService iProductoService;

    @GetMapping("get-all-productos")
    public List<Producto> getAllProductos(){
        return this.iProductoService.getAllProductos();
    }
    @GetMapping("buscar-producto")
    public List<Producto> buscarProductos(@RequestParam String nombre) throws InterruptedException {
//        Thread.sleep(3000);
        String nombreNormalizado = nombre.trim().toLowerCase();
        return this.iProductoService.findByNombreContainingIgnoreCase(nombreNormalizado);
    }

    @DeleteMapping("delete-product/{id}")
    public Boolean deleteProduct(@PathVariable("id") Long id){
        return this.iProductoService.deleteProducto(id);
    }
}
