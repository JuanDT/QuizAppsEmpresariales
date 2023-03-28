package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private CategoriaRepository categoriaRepository;
    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }



    @Override
    public List<Categoria> listarCategoria() {
        
        return categoriaRepository.findAll();
      }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);    }

    @Override
    public void eliminarCategoria(long codigo) {
        categoriaRepository.deleteById(codigo);
    }

    @Override
    public Categoria buscarCategoriaPorCodigo(long codigo) {
        return categoriaRepository.findById(codigo).orElse(null);
    }
    
}
