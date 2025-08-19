/*
Civillian.java - defines Civillian Unit type
 */
public class Civilian extends Unit {
    public static int civCount = 0;
    public Civilian(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        // create civillian unit with appropriate values
        super(50, 50, 5, true, false, "Civillian", civCount++);

    }
}