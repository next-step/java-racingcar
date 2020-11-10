package racingcar.step3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.common.Consts;
import racingcar.step3.domain.Race;
import racingcar.step3.domain.Record;

/**
 * Created : 2020-11-02 오후 12:41.
 * Developer : Seo.
 */
class RaceTest {
    Race race = null;
    ResultView rv = null;
    int turns;
    String cars;
    Record record;

    @BeforeEach
    void setUp() {
        rv = new ResultView();
        record = new Record(Consts.BEST_RECORD_INIT, Consts.WINNER_INIT);

        cars = "pobi,crong,honux";
        turns = 5;
        race = new Race(cars, turns);
    }

    @Test
    @DisplayName("경주")
    void letsRun() {
        race.run(rv, record);
    }

}