/*
Simulation.java - Implements the main game logic
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Simulation {
    private ArrayList<Unit> survivors = new ArrayList<Unit>(); // keep track of survivors
    private ArrayList<Unit> zombies = new ArrayList<Unit>(); // keep track of Zombies
    private UnitFactory unitFactory = new UnitFactory();//Not in planning docs
    private int round = 0;

    public Simulation() { }

    public void generateCharacters() {
        Random random = new Random();

        // generate random number of survivors
        int randomSurvivors = random.nextInt(20) + 1; // range 1 - 20
        for (int i = 0; i < randomSurvivors; i++) {
            survivors.add(unitFactory.createRandomSurvivor());
        }
        // generate random number of zombies
        int randomZombies = random.nextInt(20) + 1; // range 1 - 20
        for (int i = 0; i < randomZombies; i++) {
            zombies.add(unitFactory.createRandomZombie());
        }
    }

    // Generate the weapons the survivors can pick up
    public void generateWeaponsCache() {
        Random random = new Random();

        //Randomly creating cache
        ArrayList<Weapon> weaponsCache = new ArrayList<>();
        for(int i = 0; i < survivors.size(); i++) {
            // random number generated 0 - 6, corresponding weapon case is added to the cache
            int randomCache = random.nextInt(7);
            switch(randomCache) {
                case 0: // adds shotgun
                    weaponsCache.add(new Shotgun());
                    break;
                case 1: // adds SubmachineGun
                    weaponsCache.add(new SubmachineGun());
                    break;
                case 2: // Adds assault rifle
                    weaponsCache.add(new AssaultRifle());
                    break;
                case 3: // adds pistol
                    weaponsCache.add(new Pistol());
                    break;
                case 4: // adds Axe
                    weaponsCache.add(new Axe());
                    break;
                case 5: // adds crowbar
                    weaponsCache.add(new Crowbar());
                    break;
                case 6: // adds frying pan
                    weaponsCache.add(new FryingPan());
                    break;
            }
        }

        //Random survivor chooses weapon
        Collections.shuffle(weaponsCache);
        for (int i = 0; i < survivors.size(); i++) {
            int nextWeapon = random.nextInt(weaponsCache.size());
            survivors.get(i).setWeapon(weaponsCache.remove(nextWeapon));
        }
    }

    public void RunSimulation() {

        System.out.println("ZOMBIE WAR");
        //Main game logic
        generateCharacters(); // fill zombie and survivor lists
        generateWeaponsCache();//Adding a weapon to everyone

        printOpeningStatements();
        // continue running battles until zombies or survivors are empty
        while ((!zombies.isEmpty()) && (!survivors.isEmpty())) {
            System.out.println("ROUND " + round++);
            battle();
            removeDeadCharacters();
        }
        // the print statement with the matching condition will execute
        if (survivors.isEmpty()) { // if there are no survivors
            System.out.println("None of the survivors made it");
        }
        else if (survivors.size() == 1) { // if there is 1 survivor
            System.out.println("It seems only 1 survivor made it to safety");
        }
        else { // if there are multiple survivors
            System.out.printf("It seems %d survivors made it to safety.\n", survivors.size());
        }
    }

    // battle function - Fixed to prevent multiple kill messages and show weapons used
    public void battle() {
        // Create lists to track who killed whom to avoid duplicate messages
        ArrayList<Unit> deadZombies = new ArrayList<>();
        ArrayList<Unit> deadSurvivors = new ArrayList<>();
                
        // first, each survivor will attack each zombie
        for (Unit survivor : survivors) {
            for (Unit zombie : zombies) {
                if (zombie.isAlive()) { // Only attack if zombie is still alive
                    int damageDealt = survivor.getAttackPowerWithWeapon();
                    if (damageDealt > 0) { // Only attack if weapon hit (didn't miss)
                        zombie.takeDamage(damageDealt);
                        
                        // Check if this attack killed the zombie
                        if (!zombie.isAlive() && !deadZombies.contains(zombie)) {
                            deadZombies.add(zombie); // Mark as dead to prevent duplicate messages
                            System.out.printf("%s killed %s with %s\n",
                                    survivor, zombie, survivor.getWeaponName());
                        }
                    }
                }
            }
        }
        
        // next, each zombie will attack each survivor

        for (Unit zombie : zombies) {
            for (Unit survivor : survivors) {
                if (survivor.isAlive()) { // Only attack if survivor is still alive
                    zombie.attack(survivor);
                    
                    // Check if this attack killed the survivor
                    if (!survivor.isAlive() && !deadSurvivors.contains(survivor)) {
                        deadSurvivors.add(survivor); // Mark as dead to prevent duplicate messages
                        System.out.printf("%s killed %s with its bare hands\n",
                                zombie, survivor);
                    }
                }
            }
        }
        System.out.println("------------------------------------------------------------------");

    }
    public void printOpeningStatements() {
        // opening print statements
        System.out.println("------------------------------------------------------------------");
        System.out.printf("We have %d survivors trying to make it to safety. \n", survivors.size());
        System.out.printf("(%d scientists, %d civillians, %d soldiers)\n",
                Scientist.scientistCount, Civilian.civCount, Soldier.soldierCount);
        System.out.printf("But we have %d zombies waiting for them. \n", zombies.size());
        System.out.printf("(%d common infected, %d tanks)\n", CommonInfected.comInfCount, Tank.tankCount);
        System.out.println("How many survivors will make it to safety...");
        System.out.println("------------------------------------------------------------------");
    }

    public void removeDeadCharacters() {
        // Use removeIf for safer removal during iteration
        survivors.removeIf(survivor -> !survivor.isAlive());
        zombies.removeIf(zombie -> !zombie.isAlive());
    }
}
