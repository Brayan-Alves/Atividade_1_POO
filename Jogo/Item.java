package Jogo;

public class Item {
    private String nome;
    private boolean seEquipado;

    public Item(String nome, boolean seEquipado) {
        this.nome = nome;
        this.seEquipado = seEquipado;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isSeEquipado() {
        return seEquipado;
    }
    public void setSeEquipado(boolean seEquipado) {
        this.seEquipado = seEquipado;
    }
}
