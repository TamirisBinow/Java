package UVVFlix;

import java.util.ArrayList;

//foi usado IA para revisar

public class Sessao {

    // variáveis
    private boolean statusSessao;
    private String horario;
    private ArrayList<Filme> filmes;

    // construtores
    public Sessao() {
        this.filmes = new ArrayList<Filme>();
    }

    public Sessao(boolean statusSessao, String horario) {
        this.statusSessao = statusSessao;
        this.horario = horario;
        this.filmes = new ArrayList<Filme>();
    }

    public Sessao(boolean statusSessao, String horario, Filme filme) {
        this.statusSessao = statusSessao;
        this.horario = horario;
        this.filmes = new ArrayList<Filme>();
        this.filmes.add(filme);
    }

    // acessar atributos privados
    public boolean getStatusSessao() {
        return statusSessao;
    }

    public void setStatusSessao(boolean statusSessao) {
        this.statusSessao = statusSessao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

   
    public Filme getFilme() {
        if (filmes.size() > 0) {
            return filmes.get(0);
        }

        return null;
    }


    public void setFilme(Filme filme) {
        filmes.clear();
        filmes.add(filme);
    }

    // métodos
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(int indice) {
        if (indice >= 0 && indice < filmes.size()) {
            filmes.remove(indice);
        }
    }

    public void alterarFilme(int indice, Filme novoFilme) {
        if (indice >= 0 && indice < filmes.size()) {
            filmes.set(indice, novoFilme);
        }
    }

    public Filme buscarFilmePorIndice(int indice) {
        if (indice >= 0 && indice < filmes.size()) {
            return filmes.get(indice);
        }

        return null;
    }

    public int quantidadeFilmes() {
        return filmes.size();
    }

    public String listarFilmesDaSessao() {
        String lista = "";

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);

            lista += "Filme " + i
                    + "\nTítulo: " + filme.getTitulo()
                    + "\nDuração: " + filme.getDuracao() + " minutos"
                    + "\nGênero: " + filme.getGenero();
        }

        if (lista.equals("")) {
            lista = "Nenhum filme cadastrado nesta sessão.";
        }

        return lista;
    }

    public String resumoSessao() {
        return "Status: " + (statusSessao ? "Ativa" : "Inativa")
                + "\nHorário: " + horario
                + "\nQuantidade de filmes: " + filmes.size()
                + "\n" + listarFilmesDaSessao();
    }

    public String toString() {
        return "Horário: " + horario
                + " | Status: " + (statusSessao ? "Ativa" : "Inativa")
                + " | Filmes: " + filmes.size();
    }
}