package com.gestao_livraria.repository;

import com.gestao_livraria.model.Livro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LivroRepository {

    public void criar(Livro livro){
        String query = "INSERT INTO livros (titulo, autor, nacionalidade, categoria, preco, estoque)";

        PreparedStatement ps;
        ResultSet rs;

        try{
            ps = new PreparedStatement();
            rs = ps.executeQuery()
        }
    }

    public void remover(String codigo){

    }

    public Livro buscarPorCodigo(String codigo){
        return null;
    }

    public Livro buscarPorTitulo(String titulo){
        return null;
    }

    public Livro buscarPorAutor(String nome){
        return null;
    }

    public Livro buscarPorNacionalidade(String nacionalidade){
        return null;
    }
}
