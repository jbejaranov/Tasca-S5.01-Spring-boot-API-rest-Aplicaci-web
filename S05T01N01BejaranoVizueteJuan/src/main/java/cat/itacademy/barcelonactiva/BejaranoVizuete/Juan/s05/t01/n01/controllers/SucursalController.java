package cat.itacademy.barcelonactiva.BejaranoVizuete.Juan.s05.t01.n01.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.BejaranoVizuete.Juan.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BejaranoVizuete.Juan.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BejaranoVizuete.Juan.s05.t01.n01.model.services.SucursalService;

@Controller
@RequestMapping("/sucursals")
public class SucursalController {

	private final Logger logg = LoggerFactory.getLogger(Sucursal.class);

	@Autowired
	SucursalService sucursalService;

	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("sucursals", sucursalService.mostraSucursals());

		return "home";
	}

	@GetMapping("/create")
	public String create() {

		return "create";
	}

	@PostMapping("/save")
	public String save(Sucursal sucursal) {
		logg.info("Informació de Sucursal", sucursal);
		SucursalDTO sucursalDTO = canviaASucursalDTO(sucursal);
		sucursalService.desaSucursal(sucursalDTO);
		return "redirect:/sucursals";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		SucursalDTO sucursalDTO = sucursalService.mostraSucursal(id);
		logg.info("Sucursal obtinguda {}", sucursalDTO);
		model.addAttribute("sucursal", sucursalDTO);
		return "edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		sucursalService.eliminaSucursal(id);
		logg.info("Sucursal eliminada {}");
		return "redirect:/sucursals";
	}

	public SucursalDTO canviaASucursalDTO(Sucursal sucursal) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
		sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
		sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
		sucursalDTO.setTipusSucursal(sucursal.getPaisSucursal());
		return sucursalDTO;
	}
}