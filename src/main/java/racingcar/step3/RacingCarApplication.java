package racingcar.step3;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Race;
import racingcar.step3.domain.Record;
import racingcar.step3.view.InputView;
import racingcar.step3.view.ResultView;

import racingcar.step3.domain.Race;
import racingcar.step3.view.InputView;

/**
 * Created : 2020-11-02 오전 8:21
 * Developer : Seo
 */
public class RacingCarApplication {
    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();
        Record record = new Record(Consts.BEST_RECORD_INIT, Consts.WINNER_INIT);

        String names = iv.getNames();
        int turns = iv.getTurns();

        Race race = new Race(names, turns);
        race.run(rv, record);
    }

}
