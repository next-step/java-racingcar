package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int BEGIN_INDEX = 0;
    private static final int INIT_VALUE = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return this.cars.size();
    }

    public List<Car> moveCount(List<Integer> numbers) {
        for (int i = BEGIN_INDEX; i < numbers.size(); i++) {
            move(i, numbers.get(i));
        }
        return this.cars;
    }

    private void move(int i, int number) {
        this.cars.get(i).move(number);
    }

    public List<Car> winningCars() {
        return makeWinningCars();
    }

    private List<Car> makeWinningCars() {
        int maxMoveCount = maxMoveCount();
        List<Car> winningCars = new ArrayList<>();

        for (Car car : cars) {
            makeWiningCar(maxMoveCount, winningCars, car);
        }
        return winningCars;
    }

    private void makeWiningCar(int maxMoveCount, List<Car> winningCars, Car car) {
        if(car.moveCount().isEqualTo(maxMoveCount)) {
            winningCars.add(car);
        }
    }

    private int maxMoveCount() {
        int maxMoveCount = INIT_VALUE;

        for (Car car : cars) {
            maxMoveCount = makeMaxMoveCount(maxMoveCount, car);
        }
        return maxMoveCount;
    }

    private int makeMaxMoveCount(int maxMoveCount, Car car) {
        if(car.moveCount().isGreaterThan(maxMoveCount)) {
            maxMoveCount = car.moveCount().value();
        }
        return maxMoveCount;
    }
}
