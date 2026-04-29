package war;

public class Guerreiro {

    // variáveis
    private String nome;
    private int qtdVidas;

    // relacionamento com Bolsa
    private Bolsa myBolsa;

    // construtor 
    public Guerreiro() {
    }

    public Guerreiro(String nome, int qtdVidas, Bolsa myBolsa) {
        this.nome = nome;
        this.qtdVidas = qtdVidas;
        this.myBolsa = myBolsa;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getQtdVidas() {
        return qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }

    public Bolsa getMyBolsa() {
        return myBolsa;
    }

    public void setMyBolsa(Bolsa myBolsa) {
        this.myBolsa = myBolsa;
    }

    // método 
    public String vidaExtra() {
        return InOut.leString(
                "Digite seu pedido de misericórdia:",
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\suplicar_32x32.png"
        );
    }
}