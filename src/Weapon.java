public class Weapon {
    private Integer damage;
    private Integer accuracy;

    public Weapon(Integer damage, Integer accuracy) {
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public Integer getDamage() {
        return this.damage;
    }

    public Integer getAccuracy() {
        return this.accuracy;
    }
}
