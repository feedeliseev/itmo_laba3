package objects;

import enums.Gender;
import intefaces.CharacterActions;

public class Znaika extends Entity implements CharacterActions {
    private Gender gender;
    private int intellect; // From 1 to 4

    public Znaika(String name, int bravery, Gender gender, int intellect) {
        super(name, bravery);
        this.gender = gender;
        this.intellect = intellect;
    }

    public Gender getGender() {
        return gender;
    }

    public int getIntellect() {
        return intellect;
    }

    public Region buildBalloon(Region r) throws Exception {
        // Проверяем, доступен ли ресурс "rubber" и интеллект
        if (intellect == 1 || !"rubber".equals(r.availableResources())) {
            throw new Exception(name + " не смог построить шар.");
        } else if (intellect == 2) {
            System.out.println(name + " построил ненадежный шар.");
        } else if (intellect >= 3) {
            System.out.println(name + " построил надежный шар.");
        }

        // Обновляем ресурсы региона после строительства
        return r.withUpdatedResources("used");
    }

    public void buildAirship() throws Exception {
        if (intellect < 3) {
            throw new Exception(name + " не смог построить дирижабль.");
        } else {
            System.out.println(name + " построил дерижабль.");
        }
    }

    public void trainBrain() {
        if (intellect < 2) {
            intellect++;
            System.out.println(name + " поучился и теперь уровень интеллекта " + intellect);
        } else {
            System.out.println(name + " уже достаточно умный.");
        }
    }

    @Override
    public void flyOnSmt(Object o) throws Exception {
        if (bravery == 1) {
            throw new Exception(name + " побоялся лететь на "+ o.getName() +". ");
        } else if (bravery == 2) {
            System.out.println(name + " побоялся, но все-таки полетел на "+ o.getName() +". ");
        } else {
            System.out.println(name + " полетел на шаре!");
        }
    }


}