package racingcar;

public class Car {
    private int carNumber;
    private int position;
    private static int ZERO = 0;

    public Car() {
        this.position = ZERO;
    }

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.position = ZERO;
    }

    public Car(int carNumber, int position) {
        this.carNumber = carNumber;
        this.position = position;
    }

    public Car changeCarPosition(Car car, int randomNumber) {
        MovingStrategy movingStrategy = new MovingStrategy();
        if (movingStrategy.movable(randomNumber)) {
            return new Car(car.carNumber, car.position + 1);
        }
        return car;
    }

    public int getPosition() {
        return position;
    }

}
