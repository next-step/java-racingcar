package racingversion2.car;

import racingversion2.car.util.MoveDecider;

public class Car {

    private CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Car(String carName, int position) {
        this(CarName.of(carName), new Position(position));
    }

    public void move(int random) {
        if (MoveDecider.isMovingForwardCondition(random)) {
            position.increase();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isWinner(int winningPosition) {
        return position.isWinningPosition(winningPosition);
    }
}
