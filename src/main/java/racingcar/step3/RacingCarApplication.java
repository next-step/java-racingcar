package racingcar.step3;

import racingcar.step3.domain.Race;
import racingcar.step3.view.InputView;

/**
 * Created : 2020-11-02 오전 8:21
 * Developer : Seo
 */
public class RacingCarApplication {
    public static void main(String[] args) {
        InputView iv = new InputView();

        int cars = iv.getCars();
        int turns = iv.getTurns();

        Race race = new Race(cars, turns);
        race.run();
    }

}
