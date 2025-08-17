
public class Weapon {
    private Integer damage;
    private Integer accuracy;
    private String name;
    
    public Weapon(Integer damage, Integer accuracy, String name) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.name = name;
    }
    
    public Integer getDamage() {
        return this.damage;
    }
    
    public Integer getAccuracy() {
        return this.accuracy;
    }
    
    public String getName() {
        return this.name;
    }
}
