package com.gestao_livraria.repository;

import com.gestao_livraria.model.Autor;
import com.gestao_livraria.model.Categoria;
import com.gestao_livraria.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroRepository {

    public void criar(Livro livro){
        String query = "INSERT INTO livros (titulo, autor, nacionalidade, categoria, preco, estoque) VALUES(?,?,?,?,?,?)";

        try(Connection conn = ConnectionService.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,livro.getTitulo());
            ps.setString(2,livro.getAutor().getNome());
            ps.setString(3,livro.getAutor().getNacionalidade());
            ps.setString(4,livro.getCategoria().toString());
            ps.setDouble(5,livro.getPreco());
            ps.setInt(6,livro.getEstoque());

            ps.execute();
            System.out.println("Livro Salvo com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(String codigo){
        String sql = "DELETE FROM livros WHERE codigo=?";

        try(Connection conn = ConnectionService.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.execute();

            System.out.println("Produto com codigo: " + codigo + ", removido com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro buscarPorCodigo(String codigo){
        String sql = "SELECT * FROM livros WHERE codigo=?";

        try(Connection conn = ConnectionService.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();
            Autor autor = new Autor(
                    rs.getString(3),
                    rs.getString(4)
            );

            Livro livro = new Livro(
                    rs.getString(1),
                    rs.getString(2),
                    autor,
                    Categoria.valueOf(rs.getString(5)),
                    rs.getDouble(6),
                    rs.getInt(7)
            );

            return livro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Livro buscarPorTitulo(String titulo){
        String sql = "SELECT * FROM livros WHERE titulo=?";

        try(Connection conn = ConnectionService.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, titulo);

            ResultSet rs = ps.executeQuery();
            Autor autor = new Autor(
                    rs.getString(3),
                    rs.getString(4)
            );

            Livro livro = new Livro(
                    rs.getString(1),
                    rs.getString(2),
                    autor,
                    Categoria.valueOf(rs.getString(5)),
                    rs.getDouble(6),
                    rs.getInt(7)
            );

            return livro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro buscarPorAutor(String nome){
        String sql = "SELECT * FROM livros WHERE autor=?";

        try(Connection conn = ConnectionService.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            Autor autor = new Autor(
                    rs.getString(3),
                    rs.getString(4)
            );

            Livro livro = new Livro(
                    rs.getString(1),
                    rs.getString(2),
                    autor,
                    Categoria.valueOf(rs.getString(5)),
                    rs.getDouble(6),
                    rs.getInt(7)
            );

            return livro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro buscarPorNacionalidade(String nacionalidade){
        String sql = "SELECT * FROM livros WHERE nacionalidade=?";

        try(Connection conn = ConnectionService.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nacionalidade);

            ResultSet rs = ps.executeQuery();
            Autor autor = new Autor(
                    rs.getString(3),
                    rs.getString(4)
            );

            Livro livro = new Livro(
                    rs.getString(1),
                    rs.getString(2),
                    autor,
                    Categoria.valueOf(rs.getString(5)),
                    rs.getDouble(6),
                    rs.getInt(7)
            );

            return livro;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
