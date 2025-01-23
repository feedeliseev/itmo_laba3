package objects;

import enums.Action;
import enums.Gender;

public abstract class Entity extends Object {
    protected int bravery; // From 1 to 3

    public Entity(String name, int bravery) {
        super(name);
        this.bravery = bravery;
    }

    public int getBravery() {
        return bravery;
    }
}