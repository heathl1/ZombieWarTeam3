public class Tank extends Unit{
    public static int tankCount = 0;
    public Tank(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        // create tank unit with appropriate values
        super(150, 150, 20, true, true, "Tank", tankCount++);

    }
}