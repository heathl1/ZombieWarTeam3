public class UnitFactory {
    /* 
    public Unit createRandomSurvivor() {

    }

    public Unit createRandomZombie() {

    }

    public Unit createUnit(String type) {

    }

    public Unit createTank() {

    }

    public Unit createScientist() {

    }

    public Unit createCivilian() {
    
    }
    */

    /*
     * Creates a new unit from the human soldier template. 
     */
    public Unit createSoldier() {
        return new Unit(100, 100, 10, true, false, "Soldier"); 
    }
}