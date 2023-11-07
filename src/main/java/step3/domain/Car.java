package step3.domain;

public class Car {

    private Position position;

    private static final int DEFAULT_CAR_POSITION = 0;
    private static final int ACCEPT_MOVE_NUMBER = 4;


    public Car() {
        position = new Position(DEFAULT_CAR_POSITION);
    }

    public Car(final Car car) {
        this.position = car.position;
    }

    public int getCarPosition() {
        return position.getPosition();
    }

    public void tryMove(final int randomNumber) {
        if (randomNumber >= ACCEPT_MOVE_NUMBER) {
            this.position = position.move();
        }
    }

    public static Car copyCar(Car car) {
        return new Car(car);
    }
}
