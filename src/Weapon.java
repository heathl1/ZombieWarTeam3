/*
Weapon.java - defines weapon behavior for survivor use
 */
public class Weapon {
    // instance variables; subclasses will set these variables
    private Integer damage;
    private Integer accuracy;
    private String name;

    // constructor
    public Weapon(Integer damage, Integer accuracy, String name) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.name = name;
    }

    // getter for damage
    public Integer getDamage() {
        return this.damage;
    }

    // getter for accuracy
    public Integer getAccuracy() {
        return this.accuracy;
    }

    // getter for name
    public String getName() {
        return this.name;
    }
}
