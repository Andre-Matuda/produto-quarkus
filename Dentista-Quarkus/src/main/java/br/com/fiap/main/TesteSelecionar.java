package br.com.fiap.main;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;
import java.util.ArrayList;

public class TesteSelecionar {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DentistaDao dao = new DentistaDao();

        ArrayList<Dentista> listaDentista = (ArrayList<Dentista>) dao.selecionar();

        // Se lista for diferente de vazio
        if(listaDentista != null){
            // foreach
            for(Dentista p : listaDentista){
                System.out.println(
                        p.getCro() + " " +
                        p.getNome() + " "  +
                        p.getEspecialidade() + " " +
                        p.getCidade() + " " +
                        p.getEndereco() + " " +
                        p.getContato() + " "

                );
            }
        }
    }
}
