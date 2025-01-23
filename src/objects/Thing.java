package objects;

public abstract class Thing extends Object {
    protected int complexity;

    public Thing(String name, int complexity) {
        super(name);
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }
}