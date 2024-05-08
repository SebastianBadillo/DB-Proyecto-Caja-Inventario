package com.example.tienda.Service.impl;

import com.example.tienda.Repository.IViewRepository;
import com.example.tienda.Service.interfaces.IViewService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ViewService implements IViewService {
    private IViewRepository iViewRepository;


    @Override
    public List<Object> obtenerVistaGeneral() {
        return this.iViewRepository.obtenervistaGeneral();
    }

    @Override
    public List<Object> obtenerVistaGeneralByNombre(String nombre) {
        String nombreNormalizado = nombre.trim().toLowerCase();
        return this.iViewRepository.obtenerVistaGeneralByNombre(nombreNormalizado);
    }

    @Override
    public List<Object> obtenerVistaEspecifica(int codigo) {
        return this.iViewRepository.obtenervistaEspecifica(codigo);
    }

    @Override
    public List<Object> obtenerVistaEspecificalByNombre(String nombre) {
        String nombreNormalizado = nombre.trim().toLowerCase();
        return this.iViewRepository.obtenerVistaEspecificalByNombre(nombreNormalizado);
    }

    @Override
    @Transactional
    public void setProductInfoById(String nombre, Long codigo, Long id, Long precio) {
        this.iViewRepository.setProductInfoById(nombre, codigo, id, precio);

    }

    @Override
    @Transactional
    public void setInvInfoById(Long cantidad, Date fechain, Date fechaven, String lote, Long idInv) {
        this.iViewRepository.setInvInfoById(cantidad, fechain, fechaven, lote, idInv);
    }

    @Autowired
    public void setiViewGeneralRepository(IViewRepository iViewRepository){
        this.iViewRepository = iViewRepository;
    }
}
