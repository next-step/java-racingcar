package racingcar.domain;

public class Car {
    private final CarName carName;
    private final Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MovingStrategy movingStrategy) {
         if (movingStrategy.isMove()) {
             position.move(position);
         }
    }

    public String getName() {
        return carName.getCarName();
    }
}
