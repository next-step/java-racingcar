package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(UserInput userInput) {
        this.cars = createCars(userInput.getNamesForCars(), userInput.getNumbersOfCar());
    }

    private static List<Car> createCars(String[] namesForCars, int numbersOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numbersOfCar; i++) {
            cars.add(new Car(namesForCars[i]));
        }
        return cars;
    }

    public void makeCarsMove() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).attemptMove(isMoved());
        }
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
