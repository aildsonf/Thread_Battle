import java.util.Random;

public class Monster {
    private int monsterHP;

    public Monster() {
        this.monsterHP = 1000;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void regenerateHP() {
        Random regenAmount = new Random();
        this.monsterHP = regenAmount.nextInt(300);
    }

    public synchronized void fight(int damage) {
        monsterHP = monsterHP - damage;
        System.out.println("Evil Monster remaining HP: " + this.monsterHP);
    }

    public static void main(String[] args) throws InterruptedException {
        Monster evilMonster = new Monster();

        Character c1 = new Character("Personagem 1", 1, 10, evilMonster);
        Character c2 = new Character("Personagem 2", 5, 30, evilMonster);
        Character c3 = new Character("Personagem 3", 20, 27, evilMonster);
        Character c4 = new Character("Personagem 4", 6, 19, evilMonster);
        Character c5 = new Character("Personagem 5", 2, 13, evilMonster);

        c1.start();
        c1.join();
        c2.start();
        c2.join();
        c3.start();
        c3.join();
        c4.start();
        c4.join();
        c5.start();
        c5.join();
    }
}
