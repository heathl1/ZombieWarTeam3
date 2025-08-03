public class Unit {
    private int health;
    private int maxHealth;
    private int attackPower;
    private boolean alive;
    private boolean isZombie;
    private String unitType;
    private int id; // id to better identify which character is performing which action

    public Unit(int health, int maxHealth, int attackPower, boolean alive, boolean isZombie, String unitType, int id) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        this.alive = alive;
        this.isZombie = isZombie;
        this.unitType = unitType;
        this.id = id;
    }

    public void attack(Unit target) {
        target.takeDamage(this.attackPower);
    }

    public void takeDamage(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            this.alive = false;
        }
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public String getUnitType() {
        return this.unitType;
    }

    public boolean isZombie() {
        return this.isZombie;
    }

    public int getId() { return this.id; }

    public String toString() {
        return String.format("%s %d", unitType, getId());
    }

}
