package step3;

public class CarRacingGame {

    private Car[] cars;

    public CarRacingGame(int carCount) {
        this.cars = new Car[carCount];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
            cars[i].setMoveStrategy(new RandomMoveStrategy());
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
