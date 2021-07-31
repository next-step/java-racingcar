package racingCar.model;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private String carName;
    private final Position position;

    public Car(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.carName = carName;
        position = new Position();
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return position.move();
        }
        return position;
    }

    public String getName() {
        return carName;
    }

    public int getPosition(){
        return position.getPosition();
    }
}
