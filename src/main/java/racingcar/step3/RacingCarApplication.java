package racingcar.step3;

import racingcar.step3.domain.Race;
import racingcar.step3.view.InputView;
import racingcar.step3.view.ResultView;

/**
 * Created : 2020-11-02 오전 8:21.
 * Developer : Seo.
 */
public class RacingCarApplication {
    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();
        Race race = new Race(iv.getInputCars());
        rv.print(race.run(iv.getInputTurns()));
    }
}

