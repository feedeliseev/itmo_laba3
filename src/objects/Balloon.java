package objects;
import java.util.Random;


public class Balloon extends Thing {
    private double fallChance;

    public Balloon(String name, int complexity, double fallChance) {
        super(name, complexity);
        this.fallChance = fallChance;
    }

    public double getFallChance() {
        return fallChance;
    }

    // Метод для проверки падения шара
    public void checkFall() throws Exception {
        Random random = new Random();
        double chance = random.nextDouble();

        if (chance < fallChance) {
            throw new Exception(name+ " упал. ");
        } else {
            System.out.println(name+" смог взлететь.");
        }
    }


}