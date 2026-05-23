package br.com.fiap.main;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizar {

    // Método auxiliar para capturar os textos do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Dentista objDentista = new Dentista();
        DentistaDao dao = new DentistaDao();

        objDentista.setCro(texto("Informe o CRO do dentista que será atualizado:"));

        objDentista.setNome(texto("Nome do Dentista:"));
        objDentista.setCidade(texto("Cidade:"));
        objDentista.setContato(texto("Contato / Telefone:"));
        objDentista.setEspecialidade(texto("Especialidade:"));
        objDentista.setEndereco(texto("Endereço Residencial/Comercial:"));

        System.out.println(dao.atualizar(objDentista));
    }
}