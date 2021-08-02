package racingcargame;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> cars;
    private ResultView resultView = new ResultView();
    private int car;
    private int count;

    RacingCarGame(int car, int count) {
        this.car = car;
        this.count = count;
        cars = createCars(car);
    }

    private List<RacingCar> createCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new RacingCar());
        }
        return cars;
    }

    public void startGame(final RandomOption randomOption) {
        resultView.printResultMessage();
        for (int i = 0; i < count; i++) {
            round(randomOption);
            resultView.showResultView(cars);
        }
    }

    private void round(RandomOption randomOption) {
        for (RacingCar car : cars) {
            car.tryToMove(randomOption.randomValue());
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}