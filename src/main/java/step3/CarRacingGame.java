package step3;

public class CarRacingGame {

    private Car[] cars;

    public CarRacingGame(int carCount) {
        validate(carCount);
        this.cars = new Car[carCount];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(new RandomMoveStrategy());
        }
    }

    private void validate(int carCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
