package step3;

public class CarRacingGame {

    private Car[] cars;

    public CarRacingGame(int numberOfCar) {
        this.cars = new Car[numberOfCar];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
    }

    public Car[] getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
