package racingCar.domain;

public class Car {
    private Position curPosition;

    public Car(Position position) {
        curPosition = position;
    }

    public void racing(int randomValue) {
        curPosition.move(randomValue);
    }

    public int getPosition() {
        return curPosition.getPosition();
    }
}
