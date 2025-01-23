package objects;

import java.util.Random;

public class Airship extends Thing {
    private double explosionChance;

    public Airship(String name, int complexity, double explosionChance) {
        super(name, complexity);
        this.explosionChance = explosionChance;
    }

    public double getExplosionChance() {
        return explosionChance;
    }

    // Метод для проверки взрыва дирижабля
    public void checkExplosion() throws Exception {
        Random random = new Random();
        double chance = random.nextDouble();

        if (chance < explosionChance) {
            throw new Exception("Дирижабль взорварлся.");
        } else {
            System.out.println("Дирижабль взлетел");
        }
    }


}