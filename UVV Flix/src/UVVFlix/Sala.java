package UVVFlix;

import java.util.ArrayList;

public class Sala {

    private int idSala;
    private int numAssentos;
    private String tipoTela;
    private String localizacao;
    private ArrayList<Sessao> sessoes;

    public Sala() {
        this.sessoes = new ArrayList<Sessao>();
    }

    public Sala(int idSala, int numAssentos, String tipoTela, String localizacao) {
        this.idSala = idSala;
        this.numAssentos = numAssentos;
        this.tipoTela = tipoTela;
        this.localizacao = localizacao;
        this.sessoes = new ArrayList<Sessao>();
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(ArrayList<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public void removerSessao(int indice) {
        if (indice >= 0 && indice < sessoes.size()) {
            sessoes.remove(indice);
        }
    }

    public void alterarSessao(int indice, Sessao novaSessao) {
        if (indice >= 0 && indice < sessoes.size()) {
            sessoes.set(indice, novaSessao);
        }
    }

    public Sessao buscarSessaoPorIndice(int indice) {
        if (indice >= 0 && indice < sessoes.size()) {
            return sessoes.get(indice);
        }

        return null;
    }

    public int quantidadeSessoes() {
        return sessoes.size();
    }

    public int quantidadeFilmesEmCartaz() {
        int total = 0;

        for (Sessao sessao : sessoes) {
            total += sessao.quantidadeFilmes();
        }

        return total;
    }

    public String resumoSalaPorId(int id) {
        if (id == idSala) {
            return "ID da Sala: " + idSala
                    + "\nNúmero de assentos: " + numAssentos
                    + "\nTipo de tela: " + tipoTela
                    + "\nLocalização: " + localizacao;
        }

        return "Sala não encontrada.";
    }

    public void menu() {
        int opcao;

        do {
            opcao = InOut.leInt(
                    "MENU UVV FLIX"
                    + "\n1 - Adicionar Sessão"
                    + "\n2 - Remover Sessão"
                    + "\n3 - Listar Sessões"
                    + "\n4 - Alterar Sessão"
                    + "\n5 - Quantidade de Sessões"
                    + "\n6 - Buscar Sessão por Índice"
                    + "\n7 - Quantidade de filmes em Cartaz"
                    + "\n8 - Descrição dos Filmes"
                    + "\n9 - Resumo da Sala por ID"
                    + "\n10 - Sair"
            ,
        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

            //foi usada IA para auxiliar e revisar os Cases
            switch (opcao) {

                case 1: {
                    int indice = InOut.leInt("Digite o índice onde deseja adicionar a sessão:",
        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                    String titulo = InOut.leString("Digite o nome do filme:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    String horario = InOut.leString("Digite o horário:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    long duracao = InOut.leLong("Digite a duração:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    String genero = InOut.leString("Digite o gênero:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    String resumo = InOut.leString("Digite a sinopse:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                    Filme filme = new Filme(indice, titulo, duracao, genero, resumo);
                    Sessao sessao = new Sessao(true, horario, filme);

                    if (indice >= 0 && indice <= sessoes.size()) {
                        sessoes.add(indice, sessao);
                        InOut.MsgDeInformacao("Sucesso", "Sessão adicionada.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    } else {
                        InOut.MsgDeInformacao("Erro", "Índice inválido.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\erro.png");
                    }

                    break;
                }

                case 2: {
                    if (sessoes.isEmpty()) {
                        InOut.MsgDeInformacao("Aviso", "Nenhuma sessão cadastrada.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        break;
                    }

                    int indice = InOut.leInt("Digite o índice da sessão:",
        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                    if (indice >= 0 && indice < sessoes.size()) {
                        removerSessao(indice);
                        InOut.MsgDeInformacao("Sucesso", "Sessão removida.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    } else {
                        InOut.MsgDeInformacao("Erro", "Índice inválido.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\erro.png");
                    }

                    break;
                }

                case 3: {
                    if (sessoes.isEmpty()) {
                        InOut.MsgDeInformacao("Aviso", "Nenhuma sessão cadastrada.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        break;
                    }

                    String lista = "";

                    for (int i = 0; i < sessoes.size(); i++) {
                        Sessao sessao = sessoes.get(i);

                        lista += "Índice da sessão: " + i
                                + "\nHorário: " + sessao.getHorario()
                                + "\nStatus: " + (sessao.getStatusSessao() ? "Ativa" : "Inativa")
                                + "\n";

                        for (Filme filme : sessao.getFilmes()) {
                            lista += "\nFilme: " + filme.getTitulo()
                                    + "\nDuração: " + filme.getDuracao() + " minutos"
                                    + "\nGênero: " + filme.getGenero()
                                    + "\n";
                        }

                        lista += "\n----------------------\n";
                    }

                    InOut.MsgDeInformacao("Sessões", lista, "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    break;
                }

                case 4: {
                    if (sessoes.isEmpty()) {
                        InOut.MsgDeInformacao("Aviso", "Nenhuma sessão cadastrada.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        break;
                    }

                    int indice = InOut.leInt("Digite o índice da sessão:" ,
        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                    if (indice >= 0 && indice < sessoes.size()) {
                        String titulo = InOut.leString("Digite o novo nome do filme:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        String horario = InOut.leString("Digite o novo horário:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        long duracao = InOut.leLong("Digite a nova duração:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        String genero = InOut.leString("Digite o novo gênero:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        String resumo = InOut.leString("Digite a nova sinopse:", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                        Filme filme = new Filme(indice, titulo, duracao, genero, resumo);
                        Sessao sessao = new Sessao(true, horario, filme);

                        alterarSessao(indice, sessao);

                        InOut.MsgDeInformacao("Sucesso", "Sessão alterada.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    } else {
                        InOut.MsgDeInformacao("Erro", "Índice inválido.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\erro.png");
                    }

                    break;
                }

                case 5: {
                    InOut.MsgDeInformacao(
                            "Quantidade de Sessões",
                            "Total de sessões: " + quantidadeSessoes(), "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png"
                    );
                    break;
                }

                case 6: {
                    if (sessoes.isEmpty()) {
                        InOut.MsgDeInformacao("Aviso", "Nenhuma sessão cadastrada.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        break;
                    }

                    int indice = InOut.leInt("Digite o índice da sessão:",
        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                    if (indice >= 0 && indice < sessoes.size()) {
                        Sessao sessao = buscarSessaoPorIndice(indice);

                        String lista = "Horário: " + sessao.getHorario()
                                + "\nLocalização da Sala: " + localizacao
                                + "\n";

                        for (Filme filme : sessao.getFilmes()) {
                            lista += "\nFilme: " + filme.getTitulo()
                                    + "\nDuração: " + filme.getDuracao() + " minutos"
                                    + "\nGênero: " + filme.getGenero()
                                    + "\n";
                        }

                        InOut.MsgDeInformacao("Sessão Encontrada", lista, "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    } else {
                        InOut.MsgDeInformacao("Erro", "Índice inválido.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\erro.png");
                    }

                    break;
                }

                case 7: {
                    InOut.MsgDeInformacao(
                            "Filmes em Cartaz",
                            "Quantidade de filmes: " + quantidadeFilmesEmCartaz(), "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png"
                    );
                    break;
                }

                case 8: {
                    if (sessoes.isEmpty()) {
                        InOut.MsgDeInformacao("Aviso", "Nenhum filme cadastrado.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                        break;
                    }

                    String lista = "";

                    for (int i = 0; i < sessoes.size(); i++) {
                        Sessao sessao = sessoes.get(i);

                        lista += "Sessão: " + i
                                + "\nHorário: " + sessao.getHorario()
                                + "\n";

                        for (Filme filme : sessao.getFilmes()) {
                            lista += "\nFilme: " + filme.getTitulo()
                                    + "\nDuração: " + filme.getDuracao() + " minutos"
                                    + "\nGênero: " + filme.getGenero()
                                    + "\nAtores: " + filme.getAtores()
                                    + "\nSinopse: " + filme.getResumo()
                                    + "\n";
                        }

                        lista += "\n----------------------\n";
                    }

                    InOut.MsgDeInformacao("Descrição dos Filmes", lista, "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    break;
                }

                case 9: {
                    int id = InOut.leInt("Digite o ID da sala:",
        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");

                    InOut.MsgDeInformacao(
                            "Informações da Sala",
                            resumoSalaPorId(id), "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png"
                    );

                    break;
                }

                case 10: {
                    InOut.MsgDeInformacao("Sistema", "Encerrando menu.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\uvvflix_icone_32x32.png");
                    break;
                }

                default: {
                    InOut.MsgDeInformacao("Erro", "Opção inválida.", "C:\\Tamiris Binow\\UVV\\Trabalho poo\\UVV Flix\\src\\imagens\\erro.png");
                    break;
                }
            }

        } while (opcao != 10);
    }

    public String toString() {
        return "Sala: " + idSala
                + "\nAssentos: " + numAssentos
                + "\nTela: " + tipoTela
                + "\nLocalização: " + localizacao
                + "\nSessões: " + sessoes.size();
    }
}