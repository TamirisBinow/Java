package UVVFlix;

//nao foii usado IA
import java.util.ArrayList;

public class Ator {

    //variaveis
    private int idAtor;
    private String nome;
    private String papel;
    private ArrayList<Filme> filmes;

    
    //construtores
    public Ator() {
        this.filmes = new ArrayList<Filme>();
    }

    public Ator(int idAtor, String nome, String papel) {
        this.idAtor = idAtor;
        this.nome = nome;
        this.papel = papel;
        this.filmes = new ArrayList<Filme>();
    }
    
    
    //acessar atributos privados
    public int getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(int idAtor) {
        this.idAtor = idAtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }
    
    
    //metodos
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
    }

    public String toString() {
        return "Nome: " + nome + " | Papel: " + papel;
    }
}