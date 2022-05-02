package domain;

public class Car {

    private final String name;
    private final StringBuilder steps;
    private int forward;

    public Car(String name, StringBuilder steps, int forward) {
        this.name = name;
        this.steps = steps;
        this.forward = forward;
    }

    public static Car create(String name) {
        return new Car(name, new StringBuilder(), 0);
    }

    public String getName() {
        return name;
    }

    public StringBuilder getSteps() {
        return steps;
    }

    public int getForward() {
        return forward;
    }

    public void addForward() {
        this.forward = getForward() + 1;
    }
}
