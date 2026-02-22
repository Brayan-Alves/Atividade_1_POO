package Jogo;

public class Main {
    public static void main(String[] args) {
        
        Jogador j = new Jogador("Brayan");

        Personagem p1 = new Personagem("Brayan2708");
        j.adicionarPersonagem(p1);

        Item i1 = new Item("Espada", false);
        Item i2 = new Item("Escudo", false);

        p1.adicionarItem(i1);
        p1.adicionarItem(i2);

        p1.equiparItem("Espada");

        Guilda g1 = new Guilda("IF");
        g1.adicionarMembro(p1);

        System.out.printf("Inventário do Personagem: \n");
        int cont = 1;
        for (Item i : p1.getInventario()) {
            System.out.printf("%d. Nome: %s | Equipado: %b\n",cont, i.getNome(), i.isSeEquipado(), i.isSeEquipado());
            cont++;
        }

        System.out.printf("\nMembros da Guilda: \n");
        cont = 1;
        for (Personagem p : g1.getMembros()) {
            System.out.printf("%d. Nome: %s\n",cont, p.getNick());
        }

        System.out.println("\nItens equipados");
        cont = 1;
        for (Item i : p1.getInventario()) {
            if(i.isSeEquipado()){
                System.out.printf("%d. Nome: %s\n",cont, i.getNome(), i.isSeEquipado());
                cont++;
            }
        }

    }
}
