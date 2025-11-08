package study.racing;

import study.racing.domain.RaceAttempt;
import study.racing.domain.RaceInput;
import study.racing.view.InputView;
import study.racing.view.ResultView;

public class RaceMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RaceInput raceInput = inputView.race();

        RaceAttempt raceAttempt = new RaceAttempt(raceInput.getNumberOfCars());

        ResultView resultView = new ResultView();
        resultView.result(raceInput, raceAttempt.getResults());
    }
}
