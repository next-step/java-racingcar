package step3;

public class CarRacingGame {

    private Car[] cars;
    private int roundCount;

    public CarRacingGame(int numberOfCar, int roundCount) {
        this.cars = new Car[numberOfCar];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        this.roundCount = roundCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public void start() {
        for (int round = 0; round < roundCount; round++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
