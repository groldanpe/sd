package libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import libreria.model.Editorial;
import libreria.repository.EditorialRepository;


@Controller
public class EditorialController {
	
	@Autowired
	private EditorialRepository repositorioEditoriales;
	
	@RequestMapping("/insertarEditorial")
	public String insertar(Editorial editorial,
						   Model model) {
        
		repositorioEditoriales.save(editorial);

		return "insertarEditorial";
	}
	
	@RequestMapping("/editoriales")
	public String editoriales(Model model) {
        
		model.addAttribute("editoriales", repositorioEditoriales.findAll());

		return "editoriales";
	}

}
