package step3.domain;

import step3.util.InputUtil;

public class Car {

    private final StringBuilder steps;

    public Car(StringBuilder steps) {
        this.steps = steps;
    }

    public static Car create() {
        return new Car(new StringBuilder());
    }

    public void goOrStop() {
        int randomNumber = InputUtil.getRandomNumberBetweenZeroAndNine();

        if (this.isMovable(randomNumber)) {
            this.addStep();
        }
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }

    public void addStep() {
        this.steps.append("-");
    }

    public StringBuilder getSteps() {
        return this.steps;
    }
}
