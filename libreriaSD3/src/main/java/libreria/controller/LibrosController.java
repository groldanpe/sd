package libreria.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import libreria.model.Editorial;
import libreria.model.Libros;
import libreria.repository.EditorialRepository;
import libreria.repository.LibrosRepository;


@Controller
public class LibrosController {
	@Autowired
	private LibrosRepository repositorioLibros;
	
	@Autowired
	private EditorialRepository repositorioEditorial;
	
	@PostConstruct
	   public void init() {
		repositorioEditorial.save(new Editorial("ANAYA", 677456789, "prueba@prueba.com", "Gran via 54", "097yh"));	
		repositorioLibros.save(new Libros("Pepe", "Hola..", repositorioEditorial.findByCif("097yh"), 1996,123, "987-009-ES", 123, "Historia"));
		repositorioLibros.save(new Libros("Juan", "Hola.. v2", repositorioEditorial.findByCif("097yh"), 1996,12223, "22987-009-ES", 1223, "Geografia"));		
	   
	}
	
	@RequestMapping("/")
	public String libreria(Model model) {

		model.addAttribute("libros", repositorioLibros.findAll());

		return "libreria";
	}
	
	@RequestMapping("/busqueda")
	public String libreria(@RequestParam String autor, String categoria, Model model) {
		
		List<Libros> lib = repositorioLibros.findAll();
		lib = lib.stream().distinct().collect(Collectors.toList());
		
		model.addAttribute("listado",repositorioLibros.findAll());
		
		if(autor.equals("Todos")) {
			model.addAttribute("libros", repositorioLibros.findByCategoria(categoria));
		}
		
		if(categoria.equals("Todos")) {
			model.addAttribute("libros", repositorioLibros.findByAutor(autor));
		}
		
		if(!autor.equals("Todos") && !categoria.equals("Todos")) {
			model.addAttribute("libros", repositorioLibros.findByAutorAndCategoria(autor, categoria));
		}
		
		if(autor.equals("Todos") && categoria.equals("Todos")) {
			model.addAttribute("libros", repositorioLibros.findAll());
		}
		
		
		return "busqueda";
	}
	
	
	@RequestMapping("/filtroAtoB")
	public String filtroAtoB(@RequestParam String autor, String categoria,Model model) {
		
		List<Libros> libros =repositorioLibros.findAll();
		
		if (libros.size() > 0) {
			  Collections.sort(libros, new Comparator<Libros>() {
			      public int compare(final Libros object1, final Libros object2) {
			          return (int) (object2.getPvp() - object1.getPvp());
			      }
			  });
		}
		
		model.addAttribute("libros", libros);
		
		return "filtroAtoB";
	}
	
	@RequestMapping("/nuevoLibro")
	public String insertar(Model model) {
		
		List<Editorial> editoriales =repositorioEditorial.findAllByOrderByNombre();
		
		model.addAttribute("editoriales", editoriales);
		
		return("nuevoLibro");
	}
	
	@RequestMapping("/modificarLibro")
	public String modificarLibro(@RequestParam String isbn, Model model) {
		
		Libros lib = repositorioLibros.findByisbn(isbn);
		
		model.addAttribute("libros", lib);
		
		return("modificarLibro");
	}
	
	
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam String cif, Libros libro,
	     	Model model) {
		
		Editorial e = repositorioEditorial.findByCif(cif);
		libro.setEditorial(e);

		repositorioLibros.save(libro);
		
		e.getLibros().add(libro);		
		repositorioEditorial.save(e);

		return "insertar";
	}
	

	@RequestMapping("/modificar")
	public String modificar(@RequestParam String titulo, String autor, int ano_publicacion, int paginas, double pvp, String cif, String isbn, String categoria,
		     	Model model) {


		Libros lib = repositorioLibros.findByisbn(isbn);
		lib.setAno_publicacion(ano_publicacion);
		lib.setAutor(autor);
		lib.setPaginas(paginas);
		lib.setTitulo(titulo);
		lib.setPvp(pvp);
		lib.setIsbn(isbn);
		lib.setCategoria(categoria);
		
		Editorial e = repositorioEditorial.findByCif(cif);
		lib.setEditorial(e);

		repositorioLibros.save(lib);
		
		e.getLibros().add(lib);		
		repositorioEditorial.save(e);

		return "modificar";
	}
	
	

	@RequestMapping("/mostrarPorTitulo")
	public String mostrarPorTitulo(@RequestParam String titulo, Model model) {

		List<Libros> variosLibros = repositorioLibros.findByTitulo(titulo);

	    model.addAttribute("libros", variosLibros);

		return "mostrar";
	}
	
	@RequestMapping("/mostrarPorEditorial")
	public String mostrarPorEditorial(@RequestParam String cif, Model model) {

		Editorial e = repositorioEditorial.findByCif(cif);

    	model.addAttribute("libros", e.getLibros());

		return "mostrar";
	}

}
