package br.com.fiap.main;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserir {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        Dentista objDentista = new Dentista();

        DentistaDao dao = new DentistaDao();

        objDentista.setCro(texto("CRO"));
        objDentista.setNome(texto("Nome"));
        objDentista.setEspecialidade(texto("Especialidade"));
        objDentista.setCidade(texto("Cidade"));
        objDentista.setEndereco(texto("Endereco"));
        objDentista.setContato(texto("Contato"));

        System.out.println(dao.inserir(objDentista));
    }
}
