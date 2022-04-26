package racingcar.domain;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public void moveOrStop(RacingStrategy racingStrategy) {
        if (racingStrategy.checkCondition()) {
            position.move();
        }
    }

    public boolean isWinner(int max) {
        return position.getMovement() == max;
    }

    public int getMaxPosition(int max) {
        return Math.max(position.getMovement(), max);
    }

    public int getPosition() {
        return position.getMovement();
    }

    public String getCarName() {
        return carName.getName();
    }

}
