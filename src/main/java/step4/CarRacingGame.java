package step4;

public class CarRacingGame {

    private Car[] cars;

    public CarRacingGame(String[] carNames) {
        validate(carNames);
        this.cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i], new RandomMoveStrategy());
        }
    }

    private void validate(String[] carNames) {
        if ((carNames == null) || (carNames.length == 0)) {
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

    public Car[] getWinners() {
        return Referee.getWinners(this.cars);
    }
}
