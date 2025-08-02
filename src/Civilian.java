public class Civilian extends Unit {
    public Civilian(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        super(health, maxHealth, attackPower, alive, isZombie, unitType);
        health = 50;
        maxHealth = 50;
        attackPower = 5;
        alive = true;
        isZombie = false;
        unitType = "Civilian";
    }
}