package racingcar.step3;

import racingcar.step3.domain.Cars;
import racingcar.step3.domain.Race;
import racingcar.step3.domain.Record;
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
        Record record = new Record();
        Race race = new Race();
        Cars cars = new Cars(iv.getInputCars(), record);

        race.run(cars, iv.getInputTurns(), record);
        rv.print(cars, record);
    }
}

