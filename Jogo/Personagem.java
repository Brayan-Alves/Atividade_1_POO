package Jogo;

import java.util.LinkedList;
import java.util.List;

public class Personagem {
    private String nick;
    private List<Item> inventario;

    public Personagem(String nick) {
        this.nick = nick;
        this.inventario = new LinkedList<Item>();
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public List<Item> getInventario() {
        return inventario;
    }
    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }
    public void adicionarItem(Item i){
        this.inventario.add(i);
    }
    public void equiparItem(String item){
        for (Item i : inventario) {
            if(i.getNome().equals(item)){
                i.setSeEquipado(true);
            }
        }
    }
}
