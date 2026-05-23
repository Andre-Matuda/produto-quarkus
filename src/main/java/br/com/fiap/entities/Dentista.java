package br.com.fiap.entities;

public class Dentista {

    private String cro;
    private String nome;
    private String endereco;
    private String contato;
    private String especialidade;
    private String cidade;

    public Dentista() {
    }

    public Dentista(String cro, String nome, String endereco, String contato, String especialidade, String cidade) {
        this.cro = cro;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.especialidade = especialidade;
        this.cidade = cidade;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "cro='" + cro + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contato='" + contato + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
