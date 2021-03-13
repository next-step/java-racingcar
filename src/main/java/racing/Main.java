package racing;

import racing.domain.Cars;
import racing.domain.Winners;
import racing.view.InputView;
import racing.view.ResultView;

public class Main {

    public static void main(String[] args){
        InputView inputView = new InputView();
        inputView.inputView();
        RacingEvent racingEvent = new RacingEvent(new Cars(inputView.getCarNames()), inputView.getTryCount());
        racingEvent.startEvent();

        ResultView resultView = new ResultView(racingEvent);
    }
}
