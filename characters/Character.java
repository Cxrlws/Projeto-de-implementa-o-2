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
        this.level = 1;
        this.strength = 0;
        this.life = 100;
    }

    /*
    aqui é usado abstract porque o comportamento desses metodos vão ser distintos em cada tipo de personagem
    então o abstract permite que a gente possa fazer modificações nas funções em cada caso sem afetar o resto
    */
    public abstract int attack();
    public abstract boolean recieveDamage(int damage);
    public abstract void levelUp();

    public void showDetails(){}
    public void showDetails(Character p1, Character p2){
        p1.showDetails();
        p2.showDetails();
        /*Coloquei essa função pq acho que talvez seja necessario chamar ela pra mostrar os detalhes de cada
         * personagem envolvido no combate (aqui é polimorfodase, ja que são dois metodos com o mesmo nome)
         * 
         * --> MAS NÃO SEI SE VAI FUNCIONAR DESSE JEITO Q EU COLOQUEI AQUI!!! <--
         */

    }
    
    /*Aqui é o metodo que a gente vai utilizar pra calcular a probabilidade, então por ex:
      se o arqueiro tiver 40% de chance de acertar uma flecha, essa probabilidade vai ser
      instanciada no metodo de ataque do arqueiro, portanto se cair qualquer numero <= 40, quer
      dizer que o arqueiro acertou a flecha. Esse metodo vai ajudar a gente em qualquer questão de propabilidade
     */
    protected int rowChance() {//protected porque somente as classes que heram character podem ter acesso a essa função
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
