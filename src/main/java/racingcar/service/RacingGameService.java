package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;

public class RacingGameService {
    public final int RANDOM_RANGE = 10;

    private int moveTimes;

    private Cars cars;
    private String CAR_NAME_DELIMITER = ",";

    public RacingGameService() {
        this.cars = new Cars();
    }

    public void setCarNumber() {
        this.cars.setCarNumber(InputView.setCarNumber());
    }

    public void setCarNames() {
        this.cars.setCarNames(InputView.setCarNames().split(CAR_NAME_DELIMITER));
    }

    public void setMoveTimes() {
        moveTimes = InputView.setMoveTimes();
    }

    public void racing() {
        System.out.println("실행결과");

        for (int i = 0; i < moveTimes; i++) {
            moveCars();
            ResultView.printResultWithName(cars);
        }

        ResultView.printWinner(cars);
    }

    private void moveCars() {
        for (Car car : cars.getCar()) {
            car.move(getRandomValue());
        }
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }

    public int getCarNumber() {
        return cars.getCatNumber();
    }

    public int getMoveTimes() {
        return moveTimes;
    }

}
