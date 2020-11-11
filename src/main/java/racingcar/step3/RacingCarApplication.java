package racingcar.step3;

import racingcar.step3.common.Consts;
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
        Record record = new Record(Consts.BEST_RECORD_INIT, Consts.WINNER_INIT);
        Race race = new Race();

        String cars = iv.getCars();
        int turns = iv.getTurns();
        race.run(cars, turns, record);
        rv.print(record);
    }
}

