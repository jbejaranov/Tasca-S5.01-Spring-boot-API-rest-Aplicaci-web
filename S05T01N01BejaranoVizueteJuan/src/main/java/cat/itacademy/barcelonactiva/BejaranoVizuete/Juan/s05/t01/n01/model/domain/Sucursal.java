package cat.itacademy.barcelonactiva.BejaranoVizuete.Juan.s05.t01.n01.model.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // Entitat amb la que tractarem
@Table(name = "Sucursals") // Definim nom de la taula
@Getter
@Setter
public class Sucursal {

	@Id // Definim quina serà la primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indiquem que l'Id serà incrementable
	@Column(name = "ID")
	private Integer pk_SucursalID;

	@Column(name = "Nom")
	private String nomSucursal;

	@Column(name = "Pais")
	private String paisSucursal;

	public Sucursal() {
		super();

	}

	public Sucursal(String nomSucursal, String paisSucursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}
}