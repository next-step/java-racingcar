package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {
    List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("차1");
        carNames.add("차2");
        carNames.add("차3");
    }

    class TrueCondition implements Condition {
        @Override
        public boolean getCondition() {
            return true;
        }
    }

    @Test
    void 자동차수와_경기_횟수_테스트() {
        Race race = new Race(carNames, 5, new TrueCondition());
        assertThat(race.getCarCount()).isEqualTo(3);
        assertThat(race.getRaceCount()).isEqualTo(5);
    }

    @Test
    void 경주_테스트() {
        Race race = new Race(carNames, 5, new TrueCondition());
        race.startRace();
    }

    @Test
    void 랜덤_우승자_테스트() {
        Race race = new Race(carNames, 5, new RaceCondition(10, 4));
        race.startRace();

        assertThat(race.getWinners()).isNotEmpty();
    }

    @Test
    void 다수_우승자_테스트() {
        Race race = new Race(carNames, 5, new TrueCondition());
        race.startRace();

        assertThat(race.getWinners().size()).isEqualTo(carNames.size());
    }
}
