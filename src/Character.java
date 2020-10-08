import java.util.Random;

public class Character extends Thread {
    private String playerName;
    private int minAtk, maxAtk;
    private Monster evilMonster;
    private int totalDmg;

    public Character(String playerName, int minAtk, int maxAtk, Monster evilMonster) {
        this.playerName = playerName;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.evilMonster = evilMonster;
        this.totalDmg = 0;
    }

    @Override
    public void run() {
        try {
            Random range = new Random();
            int damage = range.nextInt(maxAtk - minAtk) + minAtk;
            totalDmg += damage;
            System.out.println(this.playerName + " deals " + damage + " damage!");
            evilMonster.fight(damage);
            System.out.println("Total DMG: " + this.totalDmg + "\n");
            Thread.sleep(800);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}