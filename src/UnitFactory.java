import java.util.Random;

public class UnitFactory {
    public Unit createRandomSurvivor() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        if(randomNumber == 0) {
            return new Scientist(randomNumber, randomNumber, randomNumber, false, false, null);
        }
        else if(randomNumber == 1) {
            return new Civilian(randomNumber, randomNumber, randomNumber, false, false, null);
        }
        else {
            return new Soldier(randomNumber, randomNumber, randomNumber, false, false, null);
        }
    }

    public Unit createRandomZombie() {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber == 0) {
            return new CommonInfected(randomNumber, randomNumber, randomNumber, false, false, null);
        }
        else {
            return new Tank(randomNumber, randomNumber, randomNumber, false, false, null);
        }
    }
/*
    //Would we need this?
    public Unit createUnit(String type) {
        return new Unit(0, 0, 0, false, false, type);
    }

 */

    public Unit createCommonInfected() {
        return new CommonInfected(0, 0, 0, false, false, null);
    }

    public Unit createTank() {
        return new Tank(0, 0, 0, false, false, null);
    }

    public Unit createScientist () {
        return new Scientist(0, 0, 0, false, false, null);
    }

    public Unit createCivilian () {
        return new Civilian(0, 0, 0, false, false, null);
    }

    public Unit createSoldier () {
        return new Soldier(0, 0, 0, false, false, null);
    }
}