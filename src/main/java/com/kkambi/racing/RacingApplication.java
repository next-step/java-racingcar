package com.kkambi.racing;

import com.kkambi.racing.domain.Cars;
import com.kkambi.racing.view.InputView;
import com.kkambi.racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int numberOfAttempts = inputView.getNumberOfTries();

        Cars cars = new Cars(carNames);

        ResultView resultView = new ResultView();
        resultView.printPhrase();

        for (int times = 1; times <= numberOfAttempts; times++) {
            cars.tryToMoveCars();
            resultView.printInformation(cars.getCars());
        }
        resultView.printWinners(cars.chooseWinners());
    }
}
