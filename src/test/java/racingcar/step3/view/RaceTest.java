package racingcar.step3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.domain.Race;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-02 오후 12:41
 * Developer : Seo
 */
class RaceTest {

    Race race = null;
    InputView iv = null;
    ResultView rv = null;

    @BeforeEach
    void setUp() {
        iv = new InputView();
        rv = new ResultView();

        int cars = 3;
        int turns = 5;
        race = new Race(cars, turns, rv);
        race.ready();
    }

    @Test
    @DisplayName("경주 준비")
    void getReady() {
        assertThat(race.getCarSet().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("경주")
    void letsRun() {
        race.run();
    }

}