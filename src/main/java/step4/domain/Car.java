package step4.domain;

public class Car {

    private static final int INITIAL_STEP = 0;

    private int steps;
    private final String name;

    public Car(String name) {
        this.steps = INITIAL_STEP;
        this.name = name;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.addStep();
        }
    }

    private void addStep() {
        this.steps += 1;
    }

    public int getSteps() {
        return this.steps;
    }

    public String getName() {
        return this.name;
    }

}
