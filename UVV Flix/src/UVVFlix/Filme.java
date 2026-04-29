package UVVFlix;

//foi usado IA para revisar
import java.util.ArrayList;

public class Filme {

    
    //variaveis
    private int idFilme;
    private String titulo;
    private long duracao;
    private String genero;
    private String resumo;
    private ArrayList<Ator> atores;

    
    //construtores
    public Filme() {
        this.atores = new ArrayList<Ator>();
    }

    public Filme(int idFilme, String titulo, long duracao, String genero, String resumo) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.resumo = resumo;
        this.atores = new ArrayList<Ator>();
    }

    
    //acessar atributos privados
    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public void setAtores(ArrayList<Ator> atores) {
        this.atores = atores;
    }

    
    // Métodos
    public void adicionarAtor(Ator ator) {
        atores.add(ator);
    }

    public void removerAtor(Ator ator) {
        atores.remove(ator);
    }

    public int quantidadeAtores() {
        return atores.size();
    }

    public String resumoFilme() {
        String listaAtores = "";

        for (Ator ator : atores) {
            listaAtores += ator.getNome() + " (" + ator.getPapel() + "), ";
        }

        return "Título: " + titulo
                + "\nGênero: " + genero
                + "\nDuração: " + duracao + " minutos"
                + "\nAtores: " + listaAtores
                + "\nSinopse: " + resumo;
    }

    public String toString() {
        return titulo;
    }
}