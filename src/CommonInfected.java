public class CommonInfected extends Unit {
    public static int comInfCount = 0; // counter to correspond with adding ID
    public CommonInfected(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        // create CommonInfected unit with appropirate values
        super(30, 30, 5, true, true, "Common Infected",comInfCount++);
    }
}