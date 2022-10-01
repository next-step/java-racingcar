package step3.domain;

public class Car {

    private int steps;

    public Car(int steps) {
        this.steps = steps;
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

}
