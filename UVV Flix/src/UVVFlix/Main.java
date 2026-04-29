package UVVFlix;

//nao foi usado IA
public class Main {

    public static void main(String[] args) {

        Sala sala = new Sala(1, 120, "3D", "Segundo andar");

        Ator ator = new Ator(1, "Robert Downey", "Homem de Ferro");
        Ator ator1 = new Ator(2, "Wagner Moura", "Capitão Nascimento");

        Filme filme = new Filme(1, "Vingadores", 120, "Ação", "Heróis");
        Filme filme1 = new Filme(2, "Tropa de Elite", 150, "Ação", "Policial");

        filme.adicionarAtor(ator);
        filme1.adicionarAtor(ator1);
        
        ator.adicionarFilme(filme);
        ator1.adicionarFilme(filme1);

        Sessao sessao = new Sessao(true, "18:00", filme);
        Sessao sessao1 = new Sessao(true, "14:00", filme1);

        sala.adicionarSessao(sessao);
        sala.adicionarSessao(sessao1);

        sala.menu();
    }
}