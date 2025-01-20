package com.example.ApiMoneda.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
@Embeddable
public class MonedaId implements Serializable{

	@Column(name="NUM_CIA")
	private Long numCia;
	
	@Column(name="CLAVE_MONEDA")
	private String claveMoneda;
    
 // Métodos equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonedaId monedaId = (MonedaId) o;
        return Objects.equals(numCia, monedaId.numCia) && Objects.equals(claveMoneda, monedaId.claveMoneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCia, claveMoneda);
    }
}
