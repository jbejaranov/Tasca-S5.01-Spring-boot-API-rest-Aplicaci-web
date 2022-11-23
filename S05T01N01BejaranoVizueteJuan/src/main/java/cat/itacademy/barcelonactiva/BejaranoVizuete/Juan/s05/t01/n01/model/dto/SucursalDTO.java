package cat.itacademy.barcelonactiva.BejaranoVizuete.Juan.s05.t01.n01.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;

	private final List<String> paisos = Arrays.asList("Alemania", "Bélgica", "Croacia", "Dinamarca", "España",
			"Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos", "Suecia", "Eslovaquia", "Estonia", "Grecia",
			"Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia",
			"Lituania", "Portugal", "Rumanía");
	private String tipusSucursal = EsUE(paisSucursal);

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(Integer pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String paisSucursal) {
		this.tipusSucursal = EsUE(paisSucursal);

	}

	public SucursalDTO() {
		super();
	}

	public SucursalDTO(String nomSucursal, String paisSucursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = EsUE(paisSucursal);

	}

	public String EsUE(String paisSucursal) {

		tipusSucursal = "Fora UE";

		if (paisos.contains(paisSucursal)) {
			tipusSucursal = "UE";
		}
		return tipusSucursal;

	}

}
