package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars;
    private Random random = new Random();

    public Cars(String inputCars) {
        cars = new ArrayList<>();
        initializeCars(inputCars);
    }

    private void initializeCars(String inputCars) {
        String[] carNames = inputCars.split(",");
        checkCarNumber(carNames.length);
        for (String carName : carNames) {
            this.addCar(new Car(carName));
        }
    }

    private void checkCarNumber(int carNumber) {
        if (carNumber <= 0) {
            throw new IllegalArgumentException("Input positive car number.");
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveAllCar() {
        for (Car car : cars) {
            car.stopOrMove(getRandomValue());
        }
    }

    private int getRandomValue() {
        return random.nextInt(10);
    }

    public final List<Car> getAllCar() {
        return cars;
    }

    public int getNumberOfCar() {
        return cars.size();
    }

}
