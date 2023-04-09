package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(UserInput userInput) {
        int numbersOfCar = userInput.getNumbersOfCar();
        List<Car> cars = createCars(numbersOfCar);
        this.cars = cars;
    }

    private static List<Car> createCars(int numbersOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numbersOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void makeCarsMove() {
        moveAttempt(cars);
    }

    private void moveAttempt(List<Car> cars) {
        cars.forEach(Car::attemptMove);
    }

    public int getSizeOfCars() {
        return cars.size();
    }

    public int getDistance(int i) {
        return cars.get(i).getCarCurrentDistance();
    }
}
