package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;

public class RacingGameService {
    private int moveTimes;
    private Cars cars;
    private String CAR_NAME_DELIMITER = ",";

    public RacingGameService() {
        this.cars = new Cars();
    }

    public void setCarNumber() {
        this.cars = new Cars(InputView.setCarNumber());
//        this.cars.setCarNumber(InputView.setCarNumber());
    }

    public void setCarNames() {
        this.cars = new Cars(InputView.setCarNames().split(CAR_NAME_DELIMITER));
//        this.cars.setCarNames(InputView.setCarNames().split(CAR_NAME_DELIMITER));
    }

    public void setMoveTimes() {
        moveTimes = InputView.setMoveTimes();
    }

    public void racing() {
        System.out.println("실행결과");

        for (int i = 0; i < moveTimes; i++) {
            cars.moveCars();
            cars.printResult();
        }

        cars.printWinner();
    }

    public int getCarNumber() {
        return cars.getCatNumber();
    }

    public int getMoveTimes() {
        return moveTimes;
    }

}
