package characters;

import java.util.Random;

public class Combat {
    private Random chance;

    private Mage mage;
    private Warrior warrior;
    private Archer archer;

    public Combat() {
        chance = new Random();
        mage = new Mage("MAGO");
        warrior = new Warrior("GUERREIRO");
        archer = new Archer("ARQUEIRO");
    }

    public Character getCombatente(int character) {
        switch (character) {
            case 1:
                return mage;
            case 2:
                return warrior;
            case 3:
                return archer;
            default:
                return null;
        }
    }

    public String getWinner(Character winner) {
        return winner.getNome();
    }

    public boolean isDead(int character) {
        return getCombatente(character).getlife() <= 0;
    }

    public Character combat(int c1, int c2) {

        Character character1 = getCombatente(c1);
        Character character2 = getCombatente(c2);

        if (isDead(c1) || isDead(c2)) {
            return null;
        }

        if(character1.getLevel() > character2.getLevel()){
            character1.levelUp();
            character2.recieveDamage(character1.attack());
            return character1;
        }

        if(character2.getLevel() > character1.getLevel()){
            character2.levelUp();
            character1.recieveDamage(character2.attack());
            return character2;
        }

        if(character1.getLevel() == character2.getLevel()){

            int attacker = chance.nextInt(2); // Randomiza o atacante

            if (attacker == 0) {
                character1.levelUp();
                character2.recieveDamage(character1.attack());
                return character1;
            } else {
                character2.levelUp();
                character1.recieveDamage(character2.attack());
                return character2;
            }
            
        }

        return null;
        
    }
}
