package racingcar;

import racingcar.controller.Race;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        Race race = new Race(new InputView(), new ResultView(), new Validator());
        race.start();
    }
}
