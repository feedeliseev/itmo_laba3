package objects;

import java.util.Objects;

public abstract class Object {
    protected String name;

    public Object(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Object object = o;
        return Objects.equals(name, object.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}