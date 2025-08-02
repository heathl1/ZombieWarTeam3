public class CommonInfected extends Unit {
    public CommonInfected(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        super(health, maxHealth, attackPower, alive, isZombie, unitType);
        health = 30;
        maxHealth = 30;
        attackPower = 5;
        alive = true;
        isZombie = true;
        unitType = "Common Infected";
    }
}