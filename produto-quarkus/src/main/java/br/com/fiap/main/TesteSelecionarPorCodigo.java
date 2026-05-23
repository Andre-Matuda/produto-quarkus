package br.com.fiap.main;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarPorCodigo {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Dentista objDentista = new Dentista();

        DentistaDao dao = new DentistaDao();

        objDentista.setCro(texto("Informe o CRO do dentista"));

        System.out.println(dao.selecionarPorCro(objDentista.getCro()));

    }

}
