package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomEngine;
import racingcar.util.ResultDto;
import racingcar.view.ResultView;

import java.util.LinkedList;
import java.util.List;

public class RacingMachine {
    private static final int ROUND_END = 0;

    private static Cars cars;

    private RacingMachine() {
    }

    public static void runMachine(String[] carNames, int numberOfRounds) {
        makeCars(carNames);
        ResultView.startGame();
        while (numberOfRounds-- > ROUND_END) {
            cars.move();
            List<ResultDto> resultDtos = cars.getCurrentStatus();
            ResultView.showResult(resultDtos);
        }
        ResultView.showWinners(cars.getWinnerNames());
    }

    private static void makeCars(String[] carNames) {
        List<Car> carList = new LinkedList<>();
        for (String carName : carNames) {
            carList.add(new Car(new RandomEngine(), carName));
        }
        cars = new Cars(carList);
    }
}
