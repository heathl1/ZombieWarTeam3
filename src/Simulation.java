import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    private ArrayList<Unit> survivors = new ArrayList<Unit>();
    private ArrayList<Unit> zombies = new ArrayList<Unit>();
    private UnitFactory unitFactory = new UnitFactory();//Not in planning docs
    //random?

    public Simulation() {
        generateCharacters();
    }

    public void generateCharacters() {
        Random random = new Random();
        int randomSurvivors = random.nextInt(20);
        for(int i = 0; i < randomSurvivors; i++) {
            survivors.add(unitFactory.createRandomSurvivor());
        }

        int randomZombies = random.nextInt(20);
        for(int i = 0; i < randomZombies; i++) {
            zombies.add(unitFactory.createRandomZombie());
        }
    }

    public void RunSimulation() {
        //Main game logic
    }

    //Would we need attack functions?

    public void removeDeadCharacters() {

    }

    public void printReport() {
        //Tank 2 killed Civilian 0?
    }
}
