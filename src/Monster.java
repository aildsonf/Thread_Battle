import java.util.*;
import java.util.concurrent.Semaphore;

public class Monster {
    private int monsterHP;
    private final Semaphore permission;

    public Monster() {
        this.monsterHP = 1000;
        this.permission = new Semaphore(1);
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public Semaphore getPermission() {
        return permission;
    }

    public void regenerateHP() {
        // O monstro regenera até 30% do HP original (1000)
        Random random = new Random();
        int regenAmount = random.nextInt(10);

        if (regenAmount >= 1 && getMonsterHP() > 0) {
            this.monsterHP += regenAmount;
            System.out.println("** MWAHAHA I RECOVERED MORE " + regenAmount + " HP!!! **");
        }
    }

    public synchronized void monsterBattle(int damage) throws InterruptedException {
        // A Thread compete pela permissão
        permission.acquire();

        if(getMonsterHP() > 300) {
            System.out.println("## Evil Boss HP: " + getMonsterHP());
        } else {
            // Se o HP do Boss for menor do que 30%, ele se regenera
            regenerateHP();
            System.out.println("## New Evil Boss HP: " + getMonsterHP());
        }
        // O HP do monstro é reduzido a partir do dano do personagem
        // ao qual ele está lutando
        monsterHP = monsterHP - damage;
        Thread.sleep(200);
    }

    public static void main(String[] args) throws InterruptedException {
        Monster evilMonster = new Monster();

        Character c1 = new Character("Personagem 1", 1, 10, evilMonster);
        Character c2 = new Character("Personagem 2", 5, 30, evilMonster);
        Character c3 = new Character("Personagem 3", 20, 27, evilMonster);
        Character c4 = new Character("Personagem 4", 6, 19, evilMonster);
        Character c5 = new Character("Personagem 5", 2, 13, evilMonster);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        while(c1.isAlive() || c2.isAlive() || c3.isAlive() || c4.isAlive() || c5.isAlive()) {
            // Para que as linhas abaixo possam ser executadas, já que a 6ª Thread é o main()
        }

        List<Character> CharacterList = new ArrayList<Character>();
        CharacterList.add(c1);
        CharacterList.add(c2);
        CharacterList.add(c3);
        CharacterList.add(c4);
        CharacterList.add(c5);

        // Personagem que causou o maior dano
        Character highDmg = Collections.max(CharacterList, Comparator.comparing(Character::getTotalDmg));
        System.out.println(highDmg.getPlayerName() + " dealt the HIGHEST damage! " + highDmg.getTotalDmg());

        // Personagem que causou o menor dano
        Character lowDmg = Collections.min(CharacterList, Comparator.comparing(Character::getTotalDmg));
        System.out.println(lowDmg.getPlayerName() + " dealt the LOWEST damage! " + lowDmg.getTotalDmg());
    }
}

