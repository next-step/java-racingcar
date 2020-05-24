package step3;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<Car> cars = new ArrayList<>();

    private int tryTimes;

    private static final String ILLEGAL_INPUT_ERROR = "Inputs can't be negative number.";

    private RacingGame() {
    }

    public RacingGame(int carsCount, int tryTimes) {

        if (carsCount < 0 || tryTimes < 0) throw new IllegalArgumentException(ILLEGAL_INPUT_ERROR);

        // set new car
        setupCars(carsCount);
        // set play times.
        this.tryTimes = tryTimes;

    }

    private void setupCars(int carsCnt) {
        for (int i = 0; i < carsCnt; i++) {
            cars.add(new Car(i, 0, new CarMoveRandomStrategy()));
        }
    }

    public void play() {
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.viewResult(cars);
        }
    }


}
