package com.example.ApiMoneda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="HU_CAT_MONEDA")
@NoArgsConstructor 
@AllArgsConstructor
@Data

public class Moneda {
	
	@EmbeddedId
	private MonedaId monedaId;
	
	@Column(name="DESRIPCION")
	private String descripcion;
	
	@Column(name="SIMBOLO")
	private String simbolo;
	
	@Column(name="ABREVIACION")
	private String abreviacion;
	
	@Column(name="MONEDA_CORRIENTE")
	private String monedaCorriente;
	
	@Column(name="STATUS")
	private String status;
	
	
	
	

}
