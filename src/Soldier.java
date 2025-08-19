/*
Soldier.java - defines the Soldier unit type
 */
public class Soldier extends Unit{
    public static int soldierCount = 0; // counter to correspond with adding ID
    public Soldier(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType) {
        // create soldier unit with appropriate values
        super(100, 100, 10, true, false, "Soldier", soldierCount++);
    }
}