package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class RaceTest {
    class TrueCondition implements Condition {
        @Override
        public boolean getCondition() {
            return true;
        }
    }

    @Test
    void 자동차수와_경기_횟수_테스트() {
        Race race = new Race(3, 5, new TrueCondition());
        assertThat(race.getCarCount()).isEqualTo(3);
        assertThat(race.getRaceCount()).isEqualTo(5);
    }

    @Test
    void 경주_테스트() {
        Race race = new Race(3, 5, new TrueCondition());
        race.startRace();
    }
}
