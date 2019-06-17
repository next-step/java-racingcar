package racingcar.controller;

import racingcar.model.CarInformation;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingGame {
    private List<String> carNames;
    private int numberOfTries;

    public boolean run() {
        if (!inputRaceSetting()) {
            return false;
        }

        List<CarInformation> resultList = race();
        awards(resultList);
        return true;
    }

    private boolean inputRaceSetting() {
        try {
            carNames = InputView.inputCarNames();
            numberOfTries = InputView.inputNumberOfTries();
        } catch (InputMismatchException exception) {
            return false;
        }
        return true;
    }

    private List<CarInformation> race() {
        Cars cars = new Cars(carNames);
        OutputView.printResultMessage();

        List<CarInformation> informationList = null;
        for (int i = 0; i < numberOfTries; i++) {
            informationList = cars.move();
            OutputView.printCars(informationList);
        }
        return informationList;
    }

    private void awards(List<CarInformation> resultList) {
        List<CarInformation> winners = Referee.judgeWinners(resultList);
        OutputView.printWinners(winners);
    }
}
