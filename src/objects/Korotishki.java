package objects;

import intefaces.CharacterActions;

public class Korotishki extends Entity implements CharacterActions {
    private int strength; // From 1 to 2
    private boolean hasWhiteSap = false;

    public Korotishki(String name, int bravery, int strength) {
        super(name, bravery);
        this.strength = strength;
    }

    public void extractWhiteSap() throws Exception {
        if (strength < 2) {
            throw new Exception(name + " недостаточно сильны, чтоб добыть белый сок.");
        }
        hasWhiteSap = true; // Обозначаем, что белый сок был успешно добыт
        System.out.println(name + " добыли белый сок.");
    }


    public Region extractRubber(Region r) throws Exception {
        if (r.availableResources() != "white sap" || strength < 2) {
            throw new Exception(name + " не смогли добыть резину.");
        }
        System.out.println(name + " добыли резину.");
        return r.withUpdatedResources("rubber");
    }

    public int getStrength() {
        return strength;
    }

    public void train() {
        if (strength < 2) {
            strength++;
            System.out.println(name + " потренировались и теперь уровень их силы " + strength);
        } else {
            System.out.println(name + " уже достаточно сильные.");
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