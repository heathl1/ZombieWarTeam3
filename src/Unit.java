/*
Unit - base class to all the survivor and zombie types
 */
import java.util.Random;
public class Unit {
    // instance variables
    private int health;
    private int maxHealth;
    private int attackPower;
    private boolean alive;
    private boolean isZombie;
    private String unitType;
    private int id; // id to better identify which character is performing which action
    private Weapon weapon;

    // Constructor with all parameters. They will be defined in the subclass
    public Unit(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType, int id) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        this.alive = alive;
        this.isZombie = isZombie;
        this.unitType = unitType;
        this.id = id;
    }

    // attack() causes damage on the target
    public void attack(Unit target) {
        target.takeDamage(this.attackPower);
    }

    // takeDamage() causes the unit to take damage instead of inflict it
    public void takeDamage(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            this.alive = false;
        }
    }

    // isAlive() - check if the unit is still alive
    public boolean isAlive() {
        return this.alive;
    }

    // getHealth() - returns current health
    public int getHealth() {
        return this.health;
    }

    // getAttackPower() - calculates apprpriate attack power based on weapon
    public int getAttackPower() {
        if(!this.unitType.equals("Tank")  && !this.unitType.equals("Common Infected")) {
            if(this.weapon == null) {
                System.out.println(this.unitType + this.id + " has no weapon");
                return this.attackPower; // Use base attack power if no weapon
            }
            Random random = new Random();
            Integer aim = random.nextInt(99) + 1;
            if(aim > this.weapon.getAccuracy()) {
                return 0;
            }
            return this.weapon.getDamage();
        }
        return attackPower;
    }
    
    // New method to get attack power with weapon (for better control in battle)
    public int getAttackPowerWithWeapon() {
        if(!this.unitType.equals("Tank")  && !this.unitType.equals("Common Infected")) {
            if(this.weapon == null) {
                return this.attackPower; // Use base attack power if no weapon
            }
            Random random = new Random();
            Integer aim = random.nextInt(100) + 1; // 1-100 for percentage
            if(aim > this.weapon.getAccuracy()) {
                return 0; // Miss
            }
            return this.weapon.getDamage();
        }
        return attackPower;
    }
    
    // New method to get weapon name for kill messages
    public String getWeaponName() {
        if (this.weapon == null) {
            return "bare hands"; // Fallback if no weapon
        }
        return this.weapon.getName();
    }
    // getUnitType() - returns the unit type
    public String getUnitType() {
        return this.unitType;
    }

    // isZombie() - returns t/f for zombie/not zombie
    public boolean isZombie() {
        return this.isZombie;
    }

    // getter for id
    public int getId() { 
        return this.id; 
    }
    // setter for weapon -- only pertains to survivor/non-zombie units
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public String toString() {
        return String.format("%s %d", unitType, getId());
    }
}
