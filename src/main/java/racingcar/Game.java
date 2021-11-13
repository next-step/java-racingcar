package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final static Random random = new Random();

    private final static int RANDOM_RANGE = 10;
    private final static int CUTLINE = 4;
    private final static int STEP = 1;

    private List<Car> cars = new ArrayList<>();

    private InputView input = new InputView();
    private ResultView resultView = new ResultView();

    public void racingCar() {
        int carsSize = input.getCarCount();
        int rounds = input.getTryCount();
        for (int i = 0; i < carsSize; i++) {
            cars.add(new Car(random, 0));
        }

        for(int i = 0; i < rounds; i++) {
            roundOne();
            resultView.printAllCarsMovement(cars);
        }
    }

    private void roundOne() {
        for (Car car: cars) {
            car.increaseMovementRandomly(RANDOM_RANGE, CUTLINE, STEP);
        }
    }
}
