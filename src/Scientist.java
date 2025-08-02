public class Scientist extends Unit{
    public Scientist(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        super(health, maxHealth, attackPower, alive, isZombie, unitType);
        health = 20;
        maxHealth = 20;
        attackPower = 2;
        alive = true;
        isZombie = false;
        unitType = "Scientist";
    }
}