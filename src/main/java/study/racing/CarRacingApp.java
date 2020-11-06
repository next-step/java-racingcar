package study.racing;

import study.racing.view.InputView;
import study.racing.view.ResultView;

public class CarRacingApp {

    public static void main(String... args) {

        InputView inputView = new InputView();
        RacingInput racingInput = inputView.getRacingInput();

        CarRacing cr = new CarRacing(racingInput);

        ResultView resultView = new ResultView();

        while(cr.isProcessAbleRound()) {
            cr.processRound();
            resultView.printResult(cr.getRoundRecords());
        }
    }

}
