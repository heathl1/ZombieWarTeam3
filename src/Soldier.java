public class Soldier extends Unit{
    public Soldier(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        super(health, maxHealth, attackPower, alive, isZombie, unitType);
        health = 100;
        maxHealth = 100;
        attackPower = 10;
        alive = true;
        isZombie = false;
        unitType = "Soldier";
    }
}