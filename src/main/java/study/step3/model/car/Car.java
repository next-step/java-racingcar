package study.step3.model.car;

public class Car {

    private static final int CAR_MOVE_CONDITION = 4;

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    private void moveCar() {
        distance++;
    }

    public void move(int randomNumber) {
        if (isMoveCondition(randomNumber)) {
            moveCar();
        }
    }

    private boolean isMoveCondition(int randomNumber) {
        return (randomNumber >= CAR_MOVE_CONDITION);
    }
}
