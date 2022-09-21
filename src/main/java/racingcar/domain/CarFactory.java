package racingcar.domain;

public class CarFactory {

    public static Cars createCars(int numberOfCars) {
        Cars cars = new Cars();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
