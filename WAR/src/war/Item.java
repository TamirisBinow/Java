package war;

public class Item {

    // variáveis
    private int idItem;
    private String tipoItem;
    private boolean equipado;

    // construtor 
    public Item() {
    }

    public Item(int idItem, String tipoItem, boolean equipado) {
        this.idItem = idItem;
        this.tipoItem = tipoItem;
        this.equipado = equipado;
    }

    // getters e setters
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    // método 
    public void imprimirDados() {
        InOut.MsgDeInformacao(
                "Dados do Item",
                "ID do item: " + idItem
                + "\nTipo do item: " + tipoItem
                + "\nEquipado: " + equipado,
                "C:\\Tamiris Binow\\UVV\\Trabalho poo\\WAR\\src\\imagens\\cristal_32x32.png"
        );
    }
}