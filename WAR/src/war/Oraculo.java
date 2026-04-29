package war;

public class Oraculo {

    // variáveis do diagrama
    private String nome;

    // relacionamento com Guerreiro
    private Guerreiro warrior;

    // variáveis
    private int vidasIniciais;
    private int vidasPerdidas;
    private int numeroSecretoLevel1;
    private String palpitesLevel1;
    private String respostasCorretasLevel2;
    private String respostasJogadorLevel2;
    private String resultadoLevel3;
    private boolean usouSuplica;
    private boolean usouItem;
    private String levelFinal;

    // construtor 
    public Oraculo() {
        this.palpitesLevel1 = "";
        this.respostasJogadorLevel2 = "";
    }

    public Oraculo(String nome, Guerreiro warrior) {
        this.nome = nome;
        this.warrior = warrior;
        this.palpitesLevel1 = "";
        this.respostasJogadorLevel2 = "";
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Guerreiro getWarrior() {
        return warrior;
    }

    public void setWarrior(Guerreiro warrior) {
        this.warrior = warrior;
    }

    public void setUsouSuplica(boolean usouSuplica) {
        this.usouSuplica = usouSuplica;
    }

    public void setUsouItem(boolean usouItem) {
        this.usouItem = usouItem;
    }

    public void setLevelFinal(String levelFinal) {
        this.levelFinal = levelFinal;
    }

    // método
    public void definirNome(String nome) {
        this.nome = nome;
    }

    // método 
    public int sortearVidas() {
        return (int) (Math.random() * 4) + 9;
    }

    // método 
    public String prologoIntroducao() {
        vidasIniciais = warrior.getQtdVidas();

        return "Seja bem-vindo, guerreiro " + warrior.getNome()
                + ". Você entrou no reino do Oráculo " + nome
                + " com " + warrior.getQtdVidas() + " vidas.";
    }

    public String prologoVencedor() {
        return "Parabéns, " + warrior.getNome()
                + ". Você venceu todos os desafios do Oráculo "
                + nome + ".";
    }

    // método 
    public String prologoPerdedor() {
        return "Que pena, " + warrior.getNome()
                + ". Você foi derrotado pelo Oráculo "
                + nome + ".";
    }

    // método 
    public boolean decidirVidaExtra(String frase) {
        return frase != null && frase.split(" ").length > 5;
    }

    //IA auxiliou e corrigiu
    // método 
    public boolean loadLevel01() {

        numeroSecretoLevel1 = (int) (Math.random() * 100) + 1;
        int palpite;

        while (warrior.getQtdVidas() > 0) {

            palpite = InOut.leInt(
                    "Digite um número entre 1 e 100:",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
            );

            palpitesLevel1 += palpite + " ";

            if (palpite == numeroSecretoLevel1) {
                InOut.MsgDeInformacao(
                        "Level 1",
                        "Você acertou!",
                        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
                );
                return true;
            }

            warrior.setQtdVidas(warrior.getQtdVidas() - 1);
            vidasPerdidas++;

            if (palpite < numeroSecretoLevel1) {
                InOut.MsgDeAviso(
                        "Level 1",
                        "O número secreto é maior.",
                        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
                );
            } else {
                InOut.MsgDeAviso(
                        "Level 1",
                        "O número secreto é menor.",
                        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
                );
            }
        }

        return false;
    }

    public boolean loadLevel02() {

        String resposta;
        respostasCorretasLevel2 = "1) pente | 2) ventilador | 3) chuva";
        respostasJogadorLevel2 = "";

        while (warrior.getQtdVidas() > 0) {
            resposta = InOut.leString(
                    "O que é, o que é? Tem dentes mas não morde.",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
            );

            respostasJogadorLevel2 += "1) " + resposta + " | ";

            if (resposta.equalsIgnoreCase("pente")) {
                break;
            }

            warrior.setQtdVidas(warrior.getQtdVidas() - 1);
            vidasPerdidas++;

            InOut.MsgDeAviso(
                    "Level 2",
                    "Errou! Perdeu uma vida.",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\caveira-e-ossos-da-morte_32x32.png"
            );
        }

        if (warrior.getQtdVidas() <= 0) {
            return false;
        }

        while (warrior.getQtdVidas() > 0) {
            resposta = InOut.leString(
                    "O que é, o que é? Tem asas mas não voa.",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
            );

            respostasJogadorLevel2 += "2) " + resposta + " | ";

            if (resposta.equalsIgnoreCase("ventilador")) {
                break;
            }

            warrior.setQtdVidas(warrior.getQtdVidas() - 1);
            vidasPerdidas++;

            InOut.MsgDeAviso(
                    "Level 2",
                    "Errou! Perdeu uma vida.",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\caveira-e-ossos-da-morte_32x32.png"
            );
        }

        if (warrior.getQtdVidas() <= 0) {
            return false;
        }

        while (warrior.getQtdVidas() > 0) {
            resposta = InOut.leString(
                    "O que é, o que é? Cai em pé e corre deitado.",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
            );

            respostasJogadorLevel2 += "3) " + resposta + " | ";

            if (resposta.equalsIgnoreCase("chuva")) {
                break;
            }

            warrior.setQtdVidas(warrior.getQtdVidas() - 1);
            vidasPerdidas++;

            InOut.MsgDeAviso(
                    "Level 2",
                    "Errou! Perdeu uma vida.",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\caveira-e-ossos-da-morte_32x32.png"
            );
        }

        return warrior.getQtdVidas() > 0;
    }

    public boolean loadLevel03() {

        int escolhaJogador;
        int escolhaOraculo;

        escolhaJogador = InOut.leInt(
                "Escolha:\n1 - Pedra\n2 - Papel\n3 - Tesoura",
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
        );

        escolhaOraculo = (int) (Math.random() * 3) + 1;

        if (escolhaJogador == escolhaOraculo) {
            resultadoLevel3 = "Empate";

            InOut.MsgDeInformacao(
                    "Level 3",
                    "Empate!",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
            );

            return true;
        }

        if ((escolhaJogador == 1 && escolhaOraculo == 3)
                || (escolhaJogador == 2 && escolhaOraculo == 1)
                || (escolhaJogador == 3 && escolhaOraculo == 2)) {

            resultadoLevel3 = "Vitória";

            InOut.MsgDeInformacao(
                    "Level 3",
                    "Você venceu!",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
            );

            return true;
        }

        warrior.setQtdVidas(warrior.getQtdVidas() - 1);
        vidasPerdidas++;
        resultadoLevel3 = "Derrota";

        InOut.MsgDeErro(
                "Level 3",
                "Você perdeu e perdeu uma vida.",
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\caveira-e-ossos-da-morte_32x32.png"
        );

        return warrior.getQtdVidas() > 0;
    }

    public String RelatorioFimGame() {
        return "Nome do guerreiro: " + warrior.getNome()
                + "\nNome do oráculo: " + nome
                + "\nVidas iniciais: " + vidasIniciais
                + "\nVidas restantes: " + warrior.getQtdVidas()
                + "\nVidas perdidas: " + vidasPerdidas
                + "\nNúmero secreto do Level 1: " + numeroSecretoLevel1
                + "\nPalpites do Level 1: " + palpitesLevel1
                + "\nRespostas corretas do Level 2: " + respostasCorretasLevel2
                + "\nRespostas do guerreiro no Level 2: " + respostasJogadorLevel2
                + "\nResultado do Level 3: " + resultadoLevel3
                + "\nUsou súplica: " + (usouSuplica ? "Sim" : "Não")
                + "\nUsou item da bolsa: " + (usouItem ? "Sim" : "Não")
                + "\nItens restantes na bolsa: " + warrior.getMyBolsa().getItens().size()
                + "\nLevel final alcançado: " + levelFinal;
    }
}