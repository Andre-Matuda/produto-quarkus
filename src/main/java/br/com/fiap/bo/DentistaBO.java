package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.entities.Dentista;
import br.com.fiap.dao.DentistaDao;

public class DentistaBO {

    DentistaDao dentistaDao;

    // Selecionar
    public ArrayList<Dentista> selecionarBo() throws ClassNotFoundException, SQLException {
        dentistaDao = new DentistaDao();
        // Regra de negocios
        return (ArrayList<Dentista>) dentistaDao.selecionar();
    }

    public Dentista buscarPorDentistaBO(String cro) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDao = new DentistaDao();
        // Regra de negocios
        return dentistaDao.selecionarPorCro(cro);
    }

    // Inserir
    public void inserirBo(Dentista dentista) throws ClassNotFoundException, SQLException {
        DentistaDao dentistaDao = new DentistaDao();
        // Regra de negocios
        dentistaDao.inserir(dentista);
    }

    // Atualizar
    public void atualizarBo (Dentista dentista) throws ClassNotFoundException, SQLException {
        DentistaDao dentistaDao = new DentistaDao();
        // Regra de negocios
        dentistaDao.atualizar(dentista);
    }

    // Deletar
    public void deletarBo (String cro) throws ClassNotFoundException, SQLException {
        DentistaDao dentistaDao = new DentistaDao();
        // Regra de negocios
        dentistaDao.deletar(cro);
    }


}
