package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String[] namesForCars) {
        return new Cars(Arrays.stream(namesForCars)
                        .map(Car::new)
                        .collect(Collectors.toList()));
    }

    public void makeCarsMove() {
        cars.forEach(car -> car.attemptMove(isMoved()));
    }

    private boolean isMoved() {
        return isOverFourOutOfTen(generateRandomOutOfTen());
    }

    public int countCars() {
        return cars.size();
    }

    public Car getEachCar(int carIndex) {
        return cars.get(carIndex);
    }
}
