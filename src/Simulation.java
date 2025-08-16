import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//import java.util.HashMap;

public class Simulation {
    private ArrayList<Unit> survivors = new ArrayList<Unit>();
    private ArrayList<Unit> zombies = new ArrayList<Unit>();
    private UnitFactory unitFactory = new UnitFactory();//Not in planning docs

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

    public void generateWeaponsCache() {
        Random random = new Random();

        //Randomly creating cache
        ArrayList<Weapon> weaponsCache = new ArrayList<>();
        for(int i = 0; i < survivors.size(); i++) {
            int randomCache = random.nextInt(7);
            switch(randomCache) {
                case 0:
                    weaponsCache.add(new Shotgun());
                    break;
                case 1:
                    weaponsCache.add(new SubmachineGun());
                    break;
                case 2:
                    weaponsCache.add(new AssaultRifle());
                    break;
                case 3:
                    weaponsCache.add(new Pistol());
                    break;
                case 4:
                    weaponsCache.add(new Axe());
                    break;
                case 5:
                    weaponsCache.add(new Crowbar());
                    break;
                case 6:
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
        //Main game logic
        generateCharacters(); // fill zombie and survivor lists
        generateWeaponsCache();//Adding a weapon to everyoe

        System.out.printf("We have %d survivors trying to make it to safety. ", survivors.size());
        System.out.printf("(%d scientists, %d civillians, %d soldiers)\n",
                Scientist.scientistCount, Civilian.civCount, Soldier.soldierCount);
        System.out.printf("But we have %d zombies waiting for them. ", zombies.size());
        System.out.printf("(%d common infected, %d tanks)\n", CommonInfected.comInfCount, Tank.tankCount);
        // continue running battles until zombies or survivors are empty
        while ((!zombies.isEmpty()) && (!survivors.isEmpty())) {
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

    // battle function
    public void battle() {
        // first, each survivor will attack each zombie
        for (Unit survivor : survivors) {
            for (Unit zombie : zombies) {
                survivor.attack(zombie);
                if (!zombie.isAlive() && (zombie.getHealth() + survivor.getAttackPower()) >= 0){
                    // if this was the final blow, it will print that the zombie killed the survivor
                    System.out.printf("%s killed %s\n",
                            survivor, zombie);
                }
            }

        }
        // next, each zombie will attack each survivor
        for (Unit zombie : zombies) {
            for (Unit survivor : survivors) {
                zombie.attack(survivor);
                if ((!survivor.isAlive() && (survivor.getHealth() + zombie.getAttackPower()) >= 0)){
                    System.out.printf("%s killed %s\n",
                            zombie,  survivor );
                }
            }
        }
    }

    public void removeDeadCharacters() {
        // iterate through survivors
        for (int i = 0; i < survivors.size(); i++) {
            if (!survivors.get(i).isAlive()) { // check if they're alive
                survivors.remove(survivors.get(i)); // remove survivors with no more health
            }
        }

        // iterate through zombies
        for (int i = 0; i < zombies.size(); i++) {
            if (!zombies.get(i).isAlive()) { // check if they're alive
                zombies.remove(zombies.get(i)); // remove zombie with no more health
            }
        }
    }
}
