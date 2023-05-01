package racing.controller;

import racing.model.Cars;
import racing.view.ResultView;

public class RaceGame {

    public void startRacing(String[] carNames, int attempts) {
        Cars cars = new Cars(carNames);

        ResultView.printResultInfoMessage();
        for (int i = 0; i < attempts; i++) {
            ResultView.printRoundResult(cars.move());
        }

        ResultView.printRoundWinners(cars);
    }

}
