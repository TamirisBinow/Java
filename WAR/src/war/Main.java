package war;

//usei IA para auxiliar na criação e ma revisão
public class Main {

    static boolean suplicaJaUsada = false;
    static boolean itemJaUsado = false;

    public static void main(String[] args) {

        Bolsa bolsa = new Bolsa();

        Item item1 = new Item(1, "Poção Rosa", false);
        Item item2 = new Item(2, "Poção Roxa", false);
        Item item3 = new Item(3, "Poção Azul", false);

        bolsa.adicionarItem(item1);
        bolsa.adicionarItem(item2);
        bolsa.adicionarItem(item3);

        String nomeGuerreiro = InOut.leString(
                "Digite o nome do guerreiro:",
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\gema_32x32.png"
        );

        Guerreiro guerreiro = new Guerreiro();
        guerreiro.setNome(nomeGuerreiro);
        guerreiro.setMyBolsa(bolsa);

        Oraculo oraculo = new Oraculo();
        oraculo.definirNome("Oráculo Master");
        oraculo.setWarrior(guerreiro);

        guerreiro.setQtdVidas(oraculo.sortearVidas());

        InOut.MsgDeInformacao(
                "Prólogo",
                oraculo.prologoIntroducao(),
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\gema_32x32.png"
        );

        while (true) {
            oraculo.setLevelFinal("Level 1");

            if (oraculo.loadLevel01()) {
                break;
            }

            if (!tentarRecuperarVida(oraculo, guerreiro)) {
                oraculo.setLevelFinal("Derrota no Level 1");
                encerrar(oraculo);
                return;
            }
        }

        while (true) {
            oraculo.setLevelFinal("Level 2");

            if (oraculo.loadLevel02()) {
                break;
            }

            if (!tentarRecuperarVida(oraculo, guerreiro)) {
                oraculo.setLevelFinal("Derrota no Level 2");
                encerrar(oraculo);
                return;
            }
        }

        while (true) {
            oraculo.setLevelFinal("Level 3");

            if (oraculo.loadLevel03()) {
                oraculo.setLevelFinal("Level 3 - Vitória");

                InOut.MsgDeInformacao(
                        "Vitória",
                        oraculo.prologoVencedor(),
                        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\trofeu_32x32.png"
                );

                break;
            }

            if (!tentarRecuperarVida(oraculo, guerreiro)) {
                oraculo.setLevelFinal("Derrota no Level 3");
                encerrar(oraculo);
                return;
            }
        }

        InOut.MsgDeInformacao(
                "Relatório Final",
                oraculo.RelatorioFimGame(),
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\gema_32x32.png"
        );
    }

    public static boolean tentarRecuperarVida(Oraculo oraculo, Guerreiro guerreiro) {

        if (guerreiro.getQtdVidas() > 0) {
            return true;
        }

        if (!suplicaJaUsada) {
            suplicaJaUsada = true;
            oraculo.setUsouSuplica(true);

            String frase = guerreiro.vidaExtra();

            if (oraculo.decidirVidaExtra(frase)) {
                guerreiro.setQtdVidas(1);

                InOut.MsgDeInformacao(
                        "Vida Extra",
                        "O Oráculo concedeu uma última chance!",
                        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\pocao_32x32.png"
                );

                return true;
            } else {
                InOut.MsgDeAviso(
                        "Vida Extra",
                        "Pedido negado pelo Oráculo.",
                        "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\bolsa-de-compras_32x32.png"
                );
            }
        }

        if (!itemJaUsado && !guerreiro.getMyBolsa().getItens().isEmpty()) {
            itemJaUsado = true;

            int verItens = InOut.leInt(
                    "Deseja ver os itens da bolsa?"
                    + "\n1 - Sim"
                    + "\n2 - Não",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\bolsa-de-compras_32x32.png"
            );

            if (verItens == 1) {
                guerreiro.getMyBolsa().imprimirItens();
            }

            int opcao = InOut.leInt(
                    "Deseja usar um item da bolsa para ganhar 1 vida?"
                    + "\n1 - Sim"
                    + "\n2 - Não",
                    "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\bolsa-de-compras_32x32.png"
            );

            if (opcao == 1) {

                if (guerreiro.getMyBolsa().usarItem()) {
                    guerreiro.setQtdVidas(1);
                    oraculo.setUsouItem(true);

                    InOut.MsgDeInformacao(
                            "Bolsa",
                            "Você usou um item da bolsa para ganhar 1 vida!",
                            "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\pocao_32x32.png"
                    );

                    return true;
                }
            }
        }

        return false;
    }

    private static void encerrar(Oraculo oraculo) {
        InOut.MsgDeErro(
                "Derrota",
                oraculo.prologoPerdedor(),
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\caveira-e-ossos-da-morte_32x32.png"
        );

        InOut.MsgDeInformacao(
                "Relatório Final",
                oraculo.RelatorioFimGame(),
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\gema_32x32.png"
        );
    }
}