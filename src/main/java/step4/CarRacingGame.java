package step4;

public class CarRacingGame {

    private Car[] cars;

    public CarRacingGame(int carCount, String[] carNames) {
        validate(carCount, carNames);
        this.cars = new Car[carCount];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i], new RandomMoveStrategy());
        }
    }

    private void validate(int carCount, String[] carNames) {
        if (carCount <= 0 || carCount != carNames.length) {
            throw new IllegalArgumentException();
        }
    }

    public Car[] getCars() {
        return this.cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
