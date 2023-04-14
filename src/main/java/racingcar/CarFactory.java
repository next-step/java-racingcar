package racingcar;

public class CarFactory {

    static public Car[] createCars(int numberOfCars) {
        Car[] cars = new Car[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = new Car();
        }

        return cars;
    }
}
