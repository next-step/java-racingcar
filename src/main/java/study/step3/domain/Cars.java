package study.step3.domain;

public class Cars {
    private final Car[] cars;

    public Cars(int numberOfCars) {
        Car[] cars = new Car[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = new Car();
        }
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }
}
