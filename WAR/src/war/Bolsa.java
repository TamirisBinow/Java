package war;

import java.util.ArrayList;

public class Bolsa {

   
    private ArrayList<Item> itens;

    // construtor 
    public Bolsa() {
        this.itens = new ArrayList<Item>();
    }

    // construtor 
    public Bolsa(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    // adiciona item na bolsa
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    // remove item da bolsa
    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void equipar() {
        if (!itens.isEmpty()) {
            itens.get(0).setEquipado(true);
        }
    }

   
    public void desequipar() {
        for (Item item : itens) {
            item.setEquipado(false);
        }
    }

    public boolean usarItem() {
        if (!itens.isEmpty()) {
            Item item = itens.get(0);
            item.setEquipado(true);
            item.imprimirDados();

            itens.remove(item);
            return true;
        }

        return false;
    }

    public void imprimirItens() {
        for (Item item : itens) {
            item.imprimirDados();
        }
    }
}