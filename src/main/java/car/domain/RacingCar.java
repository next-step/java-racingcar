package car.domain;

import java.util.*;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MIN_CAR_COUNT = 0;

    private Cars cars;

    public RacingCar(String[] carNames) {
        cars = new Cars(carNames);
    }

    public RacingCar(String[] carNames, MovingStrategy movingStrategy) {
        cars = new Cars(carNames, movingStrategy);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void gameStart(Random random, int bound) {
        List<Integer> inputList = new ArrayList<>();
        int carsSize = cars.getCarsSize();

        for (int i = 0; i < carsSize; i++) {
            inputList.add(random.nextInt(bound));
        }

        cars.move(inputList);
    }

    public List<Car> getWinner() {
        return cars.getWinner();
    }
}
