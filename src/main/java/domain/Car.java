package domain;

public class Car {
    private static final int CAR_MOVE_BOUNDARY = 3;
    private CarName carName;
    private Position position;

    public Car(String carName, int position) {
        this(new CarName(carName), new Position(position));
    }

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void tryMoveForward(RandomNumber randomNumber) {
        if (!randomNumber.isBiggerThan(CAR_MOVE_BOUNDARY)) {
            return;
        }

        position.move();
    }
}
