package characters;

public class Mage extends Character {
    private int skillPower;
    private int dodge;
    private int dodgeChance;
    

    public Mage(String nome, int dodge) {
        super(nome);
        this.skillPower = 1;
        this.dodge = dodge;
    }
    /* Esse overfodase é pq to utilizando abstract na classe mãe, então ele me permite sobrescrever a função sem alterar na classe mãe */
    @Override
    public int attack() {
        return skillPower * getstrength();
    }

    @Override
    public boolean recieveDamage(int damage) {
        dodgeChance = rowChance(); 
        if(dodgeChance > dodge && getlife() > 0){//aqui ta sendo feito o calculo de probabilidade de esquiva...
            setlife(getlife() - damage);
            return true;
        } 
        return false;
    }

    @Override
    public void showDetails() {
        System.out.printf("=========== MAGE %s ===========\n", getNome());
        System.out.printf("# Nível --> %d\n", getLevel());
        System.out.printf("# Força --> %d\n", getstrength());
        System.out.printf("# Vidas --> %d\n", getlife());
        System.out.printf("# Habilidade Mágica --> %d\n", getSkillPower());
        System.out.printf("# Esquiva --> %d\n", getDodge());
        System.out.printf("=====================================\n");
    }

    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
    }

    public int getSkillPower() {
        return skillPower;
    }

    public void setSkillPower(int skillPower) {
        this.skillPower = skillPower;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    

}
