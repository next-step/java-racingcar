package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars;
    private Random random = new Random();

    public Cars(int carNumber) {
        cars = new ArrayList<>();
        initializeCars(carNumber);
    }

    private void initializeCars(int carNumber) {
        checkCarNumber(carNumber);
        for (int i = 0; i < carNumber; i++) {
            this.addCar(new Car());
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

    public List<Integer> getAllMoveCount() {
        List<Integer> moveCounts = new ArrayList<>();
        for (Car car : cars) {
            moveCounts.add(car.getMoveCount());
        }
        return moveCounts;
    }

    public final List<Car> getAllCar() {
        return cars;
    }

    public int getNumberOfCar() {
        return cars.size();
    }
}
