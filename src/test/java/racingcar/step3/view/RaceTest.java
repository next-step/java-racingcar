package racingcar.step3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.domain.Race;

/**
 * Created : 2020-11-02 오후 12:41
 * Developer : Seo
 */
class RaceTest {

    Race race = null;
    InputView iv = null;
    ResultView rv = null;
    int turns;
    int cars;

    @BeforeEach
    void setUp() {
        iv = new InputView();
        rv = new ResultView();

        cars = 3;
        turns = 5;
        race = new Race(cars, turns);
    }

    @Test
    @DisplayName("경주")
    void letsRun() {
        race.run();
    }

}