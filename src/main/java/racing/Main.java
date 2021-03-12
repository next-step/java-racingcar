package racing;

import racing.domain.Cars;
import racing.view.InputView;

public class Main {

    public static void main(String[] args){
        InputView inputView = new InputView();
        inputView.inputView();
        RacingEvent racingEvent = new RacingEvent(new Cars(inputView.getCarNames()), inputView.getTryCount());
        racingEvent.startEvent();
    }
}
