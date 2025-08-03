public class Scientist extends Unit{
    public static int scientistCount = 0; // counter to correspond with adding ID
    public Scientist(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        super(20, 20, 2, true, false, "Scientist", scientistCount++);
        // create scientist unit with appropriate values
    }
}