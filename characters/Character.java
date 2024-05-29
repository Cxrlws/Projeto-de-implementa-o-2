package characters;
import java.util.Random;

public abstract class Character {
    private String nome;
    private int level;
    private int strength;
    private int life;
    private int row;

    Random chance = new Random();

    public Character(String nome){  
        this.nome = nome;
        this.life = 100;
    }

    public abstract int attack();
    public abstract boolean recieveDamage(int damage);
    public abstract void levelUp();
    
    public abstract void showDetails();
    public void showDetails(Character p1, Character p2){
        p1.showDetails();
        p2.showDetails();

    }
    
    protected int rowChance() {
        row = chance.nextInt(101);
        return row;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getstrength() {
        return strength;
    }

    public void setstrength(int strength) {
        this.strength = strength;
    }

    public int getlife() {
        return life;
    }

    public void setlife(int life) {
        this.life = life;
    }

    
}
