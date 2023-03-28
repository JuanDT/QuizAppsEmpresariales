package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Categoria;

public interface CategoriaService {
    List<Categoria> listarCategoria();

    Categoria guardarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    void eliminarCategoria(long codigo);

    Categoria buscarCategoriaPorCodigo(long codigo); 
}
