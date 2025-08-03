import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    private ArrayList<Unit> survivors = new ArrayList<Unit>();
    private ArrayList<Unit> zombies = new ArrayList<Unit>();
    private UnitFactory unitFactory = new UnitFactory();//Not in planning docs

    public Simulation() { }

    public void generateCharacters() {
        Random random = new Random();
        // generate random number of survivors
        int randomSurvivors = random.nextInt(20) + 1; // range 1 - 20
        for(int i = 0; i < randomSurvivors; i++) {
            survivors.add(unitFactory.createRandomSurvivor());
        }
        // generate random number of zombies
        int randomZombies = random.nextInt(20) + 1; // range 1 - 20
        for(int i = 0; i < randomZombies; i++) {
            zombies.add(unitFactory.createRandomZombie());
        }
    }

    public void RunSimulation() {
        //Main game logic
        generateCharacters(); // fill zombie and survivor lists
        System.out.printf("We have %d survivors trying to make it to safety.\n", survivors.size());
        System.out.printf("But we have %d zombies waiting for them.\n", zombies.size());
        // continue running battles until zombies or zurvivors are empty
        while ((!zombies.isEmpty()) && (!survivors.isEmpty())) {
            battle();
            removeDeadCharacters();
        }
        System.out.printf("It seems %d made it to safety.", survivors.size());
    }

    // battle function

    public void battle() {
        // first, each survivor will attack each zombie
        for (Unit survivor : survivors) {
            for (Unit zombie : zombies) {
                survivor.attack(zombie);
            }
        }
        // next, each zombie will attack each survivor
        for (Unit zombie : zombies) {
            for (Unit survivor : survivors) {
                zombie.attack(survivor);
            }
        }
    }

    public void removeDeadCharacters() {

        // iterate through survivors
        for (int i = 0; i < survivors.size(); i++) {
            if (survivors.get(i).getHealth() <= 0) { // check health
                survivors.remove(survivors.get(i)); // remove survivors with no more health
            }
        }
        // iterate through zombies
        for (int i = 0; i < zombies.size(); i++) {
            if (zombies.get(i).getHealth() <= 0) { // check health
                zombies.remove(zombies.get(i)); // remove characters with no health left
            }
        }
    }

    public void printReport() {
        //Tank 2 killed Civilian 0?
    }
}
