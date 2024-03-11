package racing.controller;

import racing.model.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        String[] names = inputView.inputStrings();
        int attempts = inputView.inputNumber();
        Cars cars = new Cars(names);

        startRace(cars, attempts);
        endRace(cars);
    }

    private void startRace(Cars cars, int attempts) {
        resultView.appendResultHeader();

        for (int i = 0; i < attempts; i++) {
            resultView.appendCurrentSituation(cars.getCurrentSituation());
        }
    }

    private void endRace(Cars cars) {
        String result = resultView.getResultView(cars);
        System.out.println(result);
    }
    
}
