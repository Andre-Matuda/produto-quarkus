package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Dentista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DentistaDao {

    public Connection minhaConexao;

    public DentistaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir / Insert
    public String inserir(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_TDB_DENTISTA (CRO, NOME, CIDADE, CONTATO, ESPECIALIDADE, ENDERECO) VALUES (?, ?, ?, ?, ?, ?)"
        );
        stmt.setString(1, dentista.getCro());
        stmt.setString(2, dentista.getNome());
        stmt.setString(3, dentista.getCidade());
        stmt.setString(4, dentista.getContato());
        stmt.setString(5, dentista.getEspecialidade());
        stmt.setString(6, dentista.getEndereco());

        stmt.execute();
        stmt.close();

        return "Dentista Cadastrado com Sucesso!!!";
    }

    // Delete por CRO
    public String deletar(String cro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_FIAP_DENTISTA WHERE CRO = ?");
        stmt.setString(1, cro);

        stmt.execute();
        stmt.close();

        return "Dentista Deletado com Sucesso!!!";
    }

    // Update / Atualizar
    public String atualizar(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_TDB_DENTISTA SET NOME = ?, CIDADE = ?, CONTATO = ?, ESPECIALIDADE = ?, ENDERECO = ? WHERE CRO = ?"
        );
        stmt.setString(1, dentista.getNome());
        stmt.setString(2, dentista.getCidade());
        stmt.setString(3, dentista.getContato());
        stmt.setString(4, dentista.getEspecialidade());
        stmt.setString(5, dentista.getEndereco());
        stmt.setString(6, dentista.getCro()); // Onde o CRO identifica o registro

        stmt.executeUpdate();
        stmt.close();

        return "Dentista Atualizado com Sucesso!!!";
    }

    // Select All
    public ArrayList<Dentista> selecionar() throws SQLException {
        ArrayList<Dentista> listaDentista = new ArrayList<Dentista>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TDB_DENTISTA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Dentista objDentista = new Dentista();
            objDentista.setCro(rs.getString("CRO"));
            objDentista.setNome(rs.getString("NOME"));
            objDentista.setCidade(rs.getString("CIDADE"));
            objDentista.setContato(rs.getString("CONTATO"));
            objDentista.setEspecialidade(rs.getString("ESPECIALIDADE"));
            objDentista.setEndereco(rs.getString("ENDERECO"));

            listaDentista.add(objDentista);
        }
        rs.close();
        stmt.close();
        return listaDentista;
    }

    public Dentista selecionarPorCro(String cro) throws SQLException {
        Dentista objDentista = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TDB_DENTISTA WHERE CRO = ?");
        stmt.setString(1, cro);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objDentista = new Dentista();
            objDentista.setCro(rs.getString("CRO"));
            objDentista.setNome(rs.getString("NOME"));
            objDentista.setCidade(rs.getString("CIDADE"));
            objDentista.setContato(rs.getString("CONTATO"));
            objDentista.setEspecialidade(rs.getString("ESPECIALIDADE"));
            objDentista.setEndereco(rs.getString("ENDERECO"));
        }
        rs.close();
        stmt.close();
        return objDentista;
    }
}