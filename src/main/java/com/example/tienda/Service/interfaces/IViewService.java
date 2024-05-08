package com.example.tienda.Service.interfaces;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IViewService {
    List<Object> obtenerVistaGeneral();

    List<Object> obtenerVistaGeneralByNombre(String nombre);

    List<Object> obtenerVistaEspecifica(int codigo);
    List<Object> obtenerVistaEspecificalByNombre(@Param("nombre") String nombre);
    void setProductInfoById(String nombre, Long codigo, Long id, Long precio);
    void setInvInfoById(Long cantidad, Date fechain, Date fechaven, String lote, Long idInv);


}
