package racinggame;

public class Car {
    private final String name;
    private int trace;

    public Car(String name) {
        this.name = name;
        this.trace = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getTrace() {
        return this.trace;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove())
            this.trace += 1;
    }
}
