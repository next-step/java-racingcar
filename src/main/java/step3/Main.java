package step3;

import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.getEventInfo();

        RacingEvent racingEvent = new RacingEvent();
        racingEvent.readyEvent(inputView.getCarCount());
        racingEvent.startEvent(inputView.getTryCount());

        ResultView resultView = new ResultView();
        resultView.startResult();
        resultView.showRacingResult(racingEvent.getPositionHistory(), inputView.getTryCount());
    }
}