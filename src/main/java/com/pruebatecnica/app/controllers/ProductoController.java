package com.pruebatecnica.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pruebatecnica.app.models.entity.Producto;
import com.pruebatecnica.app.models.service.IProductoService;

@Controller
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", productoService.findAll());
		return "listar";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario de Producto");
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Producto producto = null;
		
		if(id > 0) {
			producto = productoService.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Producto");
			return "form";
		}
		
		productoService.save(producto);
		status.setComplete();
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			productoService.delete(id);
		}
		return "redirect:/listar";
	}
}