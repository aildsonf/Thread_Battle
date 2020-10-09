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

    public String getPlayerName() {
        return playerName;
    }

    public int getTotalDmg() {
        return totalDmg;
    }

    public void startFight() {
        // Inicia a luta com o Boss
        try {
            while (evilMonster.getMonsterHP() > 0) {
                Random range = new Random();
                int damage = range.nextInt(maxAtk - minAtk) + minAtk;
                totalDmg += damage; // Acumula o dano causado ao monstro
                evilMonster.monsterBattle(damage); // Inicia a luta

                // Exibe o dano atual causado pelo Personagem
                System.out.println("# " + this.playerName + " deals " + damage + " damage!");
                // Exibe o HP restante do Monstro
                System.out.println("# Evil Monster remaining HP: " + evilMonster.getMonsterHP());
                // Exibe o dano total causado pelo personagem até agora
                System.out.println("Total DMG: " + this.totalDmg + "\n");

                // A Thread é executada e passa a permissão
                evilMonster.getPermission().release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            startFight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}