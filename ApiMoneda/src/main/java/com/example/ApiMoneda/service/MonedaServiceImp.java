package com.example.ApiMoneda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ApiMoneda.entity.Moneda;
import com.example.ApiMoneda.entity.MonedaId;
import com.example.ApiMoneda.repository.MonedaDao;


@Service
public class MonedaServiceImp {
	
	@Autowired
	MonedaDao monedaDao;
	
	
	
	@Transactional (readOnly =  true)
	public List<Moneda> lista(){
		return (List<Moneda>) monedaDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Moneda buscarPorId(Long numCia, String claveMoneda) {
	    MonedaId id = new MonedaId(numCia, claveMoneda);
	    return monedaDao.findById(id)
	            .orElseThrow(() -> new RuntimeException("Moneda no encontrada" ));
	}

	
	@Transactional
	public boolean guardar(Moneda moneda) {
		boolean bandera = false;
		
		for(Moneda m: monedaDao.findAll()) {
			if(m.getMonedaId().equals(moneda.getMonedaId())) {
				bandera = true;
				break;
			}
		}
		if(bandera == false)
		monedaDao.save(moneda);
		return bandera;
	}
	
	@Transactional
	public boolean editar(Moneda moneda) {
		boolean flag = false;
		for(Moneda m: monedaDao.findAll()) {
			if(m.getMonedaId().equals(moneda.getMonedaId())) {
				monedaDao.save(moneda);
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	
	@Transactional
	public boolean eliminar(Moneda moneda) {
		boolean flag = false;
		for(Moneda m: monedaDao.findAll()) {
			if(m.getMonedaId().equals(moneda.getMonedaId())) {
				monedaDao.deleteById(moneda.getMonedaId());
				flag = true;
				break;
			}
		}
		return flag;
		
	}

}
