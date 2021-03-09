package racing_game;

import racing_game.domain.Cars;
import racing_game.view.InputView;

public class Main {

    public static void main(String[] args){
        InputView inputView = new InputView();
        inputView.inputView();
        RacingEvent racingEvent = new RacingEvent(new Cars(inputView.getCarNames()), inputView.getTryCount());
        racingEvent.startEvent();
    }
}
