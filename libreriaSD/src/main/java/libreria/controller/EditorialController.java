package libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import libreria.model.Editorial;
import libreria.model.Libros;
import libreria.repository.EditorialRepository;


@Controller
public class EditorialController {
	
	@Autowired
	private EditorialRepository repositorioEditoriales;
	
	@RequestMapping("/insertadaEditorial")
	public String insertar(Editorial editorial,
						   Model model) {
        
		repositorioEditoriales.save(editorial);

		return "insertadaEditorial";
	}
	
	@RequestMapping("/editoriales")
	public String editoriales(Model model) {
        
		model.addAttribute("editoriales", repositorioEditoriales.findAll());

		return "editoriales";
	}
	
	@RequestMapping("/nuevaEditorial")
	public String nuevaEditorial(Model model) {
		return "nuevaEditorial";
	}
	
	@RequestMapping("/mostrarPorCif")
	public String mostrarPorCif(@RequestParam String cif, Model model) {
		
		Editorial editorial = repositorioEditoriales.findByCif(cif);


	    model.addAttribute("editoriales", editorial);

		return "mostrarEditorial";
	}
	@RequestMapping("/EditorialModificada")
	public String EditorialModificada(@RequestParam String cif, String nombre, long telefono, String email, String direccion, Model model) {
		
		Editorial editorial = repositorioEditoriales.findByCif(cif);
		editorial.setDireccion(direccion);
		editorial.setEmail(email);
		editorial.setNombre(nombre);
		editorial.setTelefono(telefono);
		
		repositorioEditoriales.save(editorial);
		
		return("EditorialModificada");
	}
	
	@RequestMapping("/modificarEditorial")
	public String modificarEditorial(@RequestParam String cif, Model model) {
		
		Editorial ed = repositorioEditoriales.findByCif(cif);
		
		model.addAttribute("editoriales", ed);
		
		return("modificarEditorial");
	}

}
