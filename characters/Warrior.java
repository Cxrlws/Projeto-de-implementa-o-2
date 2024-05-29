package characters;

public class Warrior extends Character {
    private int combatPoints;
    private int shield;

    public Warrior(String nome) {
        super(nome);
        combatPoints = 10;
        shield = 20;
        setLevel(1);
        setstrength(5);
    }

    @Override
    public int attack() {
        return combatPoints * getstrength();
    }

    @Override
    public boolean recieveDamage(int damage) {
        if(shield > 0 && getlife() > 0){
            if (shield > damage){
                setShield(shield -= damage);
                return true;
            }
            setlife((getlife() + shield) - damage);
            setShield(0);
            return true;
            
        }else if(getlife() > 0){
            if(getlife() - damage <= 0){
                setlife(0);
                return true;
            }
            setlife(getlife() - damage);
            return true;
        }
        return false; 
    }

    @Override
    public void showDetails() {
        System.out.printf("\n=========== WARRIOR %s ===========\n", getNome());
        System.out.printf("# Nível --> %d\n", getLevel());
        System.out.printf("# Força --> %d\n", getstrength());
        System.out.printf("# Vidas --> %d\n", getlife());
        System.out.printf("# Habilidade de Combate --> %d\n", getCombatPoints());
        System.out.printf("# Escudo --> %d\n", getShield());
        System.out.printf("=====================================\n");
    }

    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
    }

    public int getCombatPoints() {
        return combatPoints;
    }

    public void setCombatPoints(int combatPoints) {
        this.combatPoints = combatPoints;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
    

}
