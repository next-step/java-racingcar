package domain;

import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.List;

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

    public int getDistance(int carIndex) {
        return cars.get(carIndex)
                .getCarCurrentDistance();
    }
}
