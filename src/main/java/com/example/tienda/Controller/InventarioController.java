package com.example.tienda.Controller;

import com.example.tienda.Model.Inventario;
import com.example.tienda.Model.Producto;
import com.example.tienda.Service.interfaces.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventario-controller")
@CrossOrigin(origins="http://localhost:4200")
public class InventarioController {
    @Autowired
    private IInventarioService iInventarioService;

    @GetMapping("/get-all-inventario")
    public List<Inventario> getAll(){
        return this.iInventarioService.getAllInventario();

    }
}
