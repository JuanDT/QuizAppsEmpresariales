package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Categoria;
import com.example.demo.service.CategoriaService;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

   
    @GetMapping({ "/",""}) 
    public String listarEmpleados(Model model) {      
        model.addAttribute("categoriasLista", categoriaService.listarCategoria());   
        return "categorias";
    }

    
    @GetMapping("/categoria")
    public String mostrarFormularioAgregar(Model model) {
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        
        return "crear_categoria";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/";
    }

    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEditar(@PathVariable("codigo") long codigo, Model model) {
        Categoria categoria = categoriaService.buscarCategoriaPorCodigo(codigo);
        model.addAttribute("categoria", categoria);
        return "editar_categoria";
    }

    @PostMapping("/modificar/{codigo}")
    public String editarCategoria(@PathVariable("codigo") long codigo, @ModelAttribute("categoria") Categoria categoria) {
        Categoria categoriaExistente = categoriaService.buscarCategoriaPorCodigo(codigo);
        categoriaExistente.setCodigo(codigo);
        categoriaExistente.setNomProducto(categoria.getNomProducto());
        categoriaExistente.setDescripcion(categoria.getDescripcion());
       

        categoriaService.actualizarCategoria(categoriaExistente);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarCategoria(@PathVariable("codigo") long codigo) {
        categoriaService.eliminarCategoria(codigo);;
        return "redirect:/";
    }
}
