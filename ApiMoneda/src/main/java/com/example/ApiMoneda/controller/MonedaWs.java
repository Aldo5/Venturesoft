package com.example.ApiMoneda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiMoneda.entity.Moneda;
import com.example.ApiMoneda.entity.MonedaId;
import com.example.ApiMoneda.service.MonedaServiceImp;

@RestController
@RequestMapping("MonedaWs")
@CrossOrigin
public class MonedaWs {
	
	@Autowired
	MonedaServiceImp imp;
	
	@GetMapping("listar")
	public List<Moneda> listar(){
		return imp.lista();
	}
	
	@PostMapping("buscar")
	public ResponseEntity<?> buscar(@RequestBody MonedaId id) {
	    try {
	        Moneda moneda = imp.buscarPorId(id.getNumCia(), id.getClaveMoneda());
	        return ResponseEntity.ok(moneda);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
	
	
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Moneda moneda){
		boolean  response = imp.guardar(moneda);
		if(response == true)
			return new ResponseEntity<>("Moneda repetida", HttpStatus.OK);
		else
			return new ResponseEntity<>(moneda, HttpStatus.CREATED);
	}
	
	@PostMapping("editar")
	public ResponseEntity<?>editar(@RequestBody Moneda moneda){
		boolean  response = imp.editar(moneda);
		if(response == true)
			return new ResponseEntity<>(moneda, HttpStatus.CREATED);
		else
			return new ResponseEntity<>("No existe esa Moneda", HttpStatus.OK);
	}
	
	@PostMapping("eliminar")
	public ResponseEntity<?>eliminar(@RequestBody Moneda moneda){
		boolean  response = imp.eliminar(moneda);
		if(response == true)
			return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
		else
			return new ResponseEntity<>("No existe esa moneda", HttpStatus.OK);
	}
}
