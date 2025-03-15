package step3;

public class Car {
    Integer moveSteps;

    private Car () {}

    public Car(int moveSteps) {
        this.moveSteps = moveSteps;
    }

    public void move() {
        moveSteps++;
    }

    public Integer getDistance() {
        return moveSteps;
    }

    public void stop() {
        return;
    }
}
