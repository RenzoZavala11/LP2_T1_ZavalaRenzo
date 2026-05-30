package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_equipo_dental")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EquipoDental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo_dental")
	private Integer nroEquipo;
	
	@EqualsAndHashCode.Include
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="costo")
	private Double costo;
	
	@Column(name="fecha_adquisicion")
	private LocalDateTime fechaAdquisicion;
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dentista")
	private Dentista dentista;
	
	@Override
	public String toString() {
	    return String.valueOf(nroEquipo);
	}
	
}
