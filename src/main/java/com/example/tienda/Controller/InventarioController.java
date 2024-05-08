package com.example.tienda.Controller;

import com.example.tienda.DTO.InfoUpdateDTO;
import com.example.tienda.DTO.InventarioDTO;
import com.example.tienda.Model.Inventario;
import com.example.tienda.Service.interfaces.IInventarioService;
import com.example.tienda.Service.interfaces.IViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario-controller")
@CrossOrigin(origins="http://localhost:4200")
public class InventarioController {
    @Autowired
    private IInventarioService iInventarioService;
    @Autowired
    private IViewService iViewService;

    @GetMapping("/get-all-inventario")
    public List<Inventario> getAll(){
        return this.iInventarioService.getAllInventario();

    }
    @GetMapping("/get-general-view")
    public List<Object> getGeneralView(){
        return this.iViewService.obtenerVistaGeneral();
    }

    @GetMapping("get-general-view-by-nombre")
    public List<Object> getGeneralViewByNombre(@RequestParam String nombre){
        return this.iViewService.obtenerVistaGeneralByNombre(nombre);
    }

    @GetMapping("get-especific-view-by-nombre")
    public List<Object> getEspecificViewByNombre(@RequestParam String nombre){
        return this.iViewService.obtenerVistaEspecificalByNombre(nombre);
    }

    @GetMapping("/get-especific-view")
    public List<Object> getEspecificView(@RequestParam String codigoStr){
        int codigo = Integer.parseInt((codigoStr));
        return this.iViewService.obtenerVistaEspecifica(codigo);
    }

    @PostMapping("/update")
    public Boolean updateTables(@RequestBody InfoUpdateDTO data){
        this.iViewService.setProductInfoById(data.getNombre(), data.getCodigo(), data.getProductoId(), data.getPrecio());
        this.iViewService.setInvInfoById(data.getCantidad(), data.getFechain(), data.getFechaven(), data.getLote(), data.getInventarioId());
        return Boolean.TRUE;
    }

    @PostMapping("add-inventario")
    public String addInventario(@RequestBody InventarioDTO inv){
        this.iInventarioService.addInventario(inv);
        return "se ha realizado la operacion";

    }

    @PutMapping("update-inventory")
    public void updateInventory(@RequestParam  String cantidad , @RequestParam  String id){
        Long cantidadNum = Long.parseLong(cantidad);
        Long idNum = Long.parseLong(id);
        this.iInventarioService.updateInventory(cantidadNum, idNum);
    }
    

}
