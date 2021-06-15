package racegame;

public class Car {
    private final String name;
    private int goStep;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int goStep) {
        this.name = name;
        this.goStep = goStep;
    }

    public void move() {
        this.goStep += 1;
    }

    public int getGoStep() {
        return goStep;
    }

    public String getName() {
        return name;
    }

    public boolean sameCheck(int max) {
        return this.goStep == max;
    }
}
