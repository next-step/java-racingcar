package racingcar.step3;

import racingcar.step3.domain.Race;
import racingcar.step3.service.InputView;
import racingcar.step3.service.ResultView;

/**
 * Created : 2020-11-02 오전 8:21
 * Developer : Seo
 */
public class RacingCarApplication {
    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();
        iv.setCars();
        iv.setTurns();

        int cars = iv.getCars();
        int turns = iv.getTurns();

        Race race = new Race(cars, turns, rv);
        race.ready();
        race.run();
    }

}
