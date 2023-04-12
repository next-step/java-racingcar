package domain;

import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(UserInput userInput) {
        this.cars = createCars(userInput.getNumbersOfCar());
    }

    private static List<Car> createCars(int numbersOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numbersOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void makeCarsMove() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).attemptMove(isMoved());
        }
    }

    private boolean isMoved() {
        return isOverFourOutOfTen();
    }

    public int countCars() {
        return cars.size();
    }

    public static int[] getEachCarMovedDistance(Cars cars) {
        return IntStream
                .range(0, cars.countCars())
                .map(cars::getDistance)
                .toArray();
    }

    public int getDistance(int carIndex) {
        return cars.get(carIndex)
                .getCarCurrentDistance();
    }
}
