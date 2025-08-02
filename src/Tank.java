public class Tank extends Unit{
    public Tank(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        super(health, maxHealth, attackPower, alive, isZombie, unitType);
        health = 150;
        maxHealth = 150;
        attackPower = 20;
        alive = true;
        isZombie = true;
        unitType = "Tank";
    }
    
}