package characters;

public class Archer extends Character{
    private int bowSkill;
    private int dexterity;
    
    public Archer(String nome) {
        super(nome);
        bowSkill = 10;
        dexterity = 2;
        setLevel(1);
        setstrength(2);
    }

    @Override
    public int attack() {
        return bowSkill * dexterity * getstrength();
    }

    @Override
    public boolean recieveDamage(int damage) {
        if(getlife() > 0) {
            if(getlife() - damage <= 0) {
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
        System.out.printf("\n=========== ARCHER %s ===========\n", getNome());
        System.out.printf("# Nível --> %d\n", getLevel());
        System.out.printf("# Força --> %d\n", getstrength());
        System.out.printf("# Vidas --> %d\n", getlife());
        System.out.printf("# Habilidade com Arco --> %d\n", getBowSkill());
        System.out.printf("# Destreza --> %d\n", getDexterity());
        System.out.printf("=====================================\n");
    }

    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
    }

    public int getBowSkill() {
        return bowSkill;
    }

    public void setBowSkill(int bowSkill) {
        this.bowSkill = bowSkill;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    
}
