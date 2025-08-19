/*
UnitFactory.java - class that manages Unit production
 */
import java.util.Random;

public class UnitFactory {
    public Unit createRandomSurvivor() { // creates random type of survivor
        Random random = new Random();
        int randomNumber = random.nextInt(3); // generate random number to correlate with survivor types
        if(randomNumber == 0) { // 0 indicates a scientist
            return new Scientist(randomNumber, randomNumber, randomNumber, false, false, null);
        }
        else if(randomNumber == 1) { // 1 indicates a civillian
            return new Civilian(randomNumber, randomNumber, randomNumber, false, false, null);
        }
        else { // anything else--2--indicates a soldier
            return new Soldier(randomNumber, randomNumber, randomNumber, false, false, null);
        }
    }

    public Unit createRandomZombie() { // creates a random type of zombie
        Random random = new Random();
        int randomNumber = random.nextInt(2); // generate random number within range of number of zombie types
        if(randomNumber == 0) { // indicates common infected
            return new CommonInfected(randomNumber, randomNumber, randomNumber, false, false, null);
        }
        else { // indicates tank
            return new Tank(randomNumber, randomNumber, randomNumber, false, false, null);
        }
    }

}