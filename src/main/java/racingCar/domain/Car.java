package racingCar.domain;

public class Car {
    private Position curPosition;

    public Car(Position position) {
        curPosition = position;
    }

    public void racing(int randomValue) {
        Condition condition = Condition.CheckCondition(randomValue);
        curPosition.move(condition);
    }

    public int getPosition() {
        return curPosition.getPosition();
    }
}
