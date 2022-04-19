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

    class FalseCondition implements Condition {
        @Override
        public boolean getCondition() {
            return false;
        }
    }

    class TrueCondition implements Condition {
        @Override
        public boolean getCondition() {
            return true;
        }
    }

    @Test
    void 경주_테스트() {
        Race race = new Race.RaceBuilder()
                .setCarNames(carNames)
                .setRaceCount(5)
                .setCondition(new TrueCondition())
                .build();

        race.startRace();
    }

    @Test
    void 랜덤_우승자_테스트() {
        Race race = new Race.RaceBuilder()
                .setCarNames(carNames)
                .setRaceCount(5)
                .setCondition(new RaceCondition(10, 4))
                .build();
        race.startRace();

        assertThat(race.getWinners()).isNotEmpty();
    }

    @Test
    void 다수_우승자_테스트() {
        Race race = new Race.RaceBuilder()
                .setCarNames(carNames)
                .setRaceCount(5)
                .setCondition(new TrueCondition())
                .build();

        race.startRace();

        assertThat(race.getWinners().size()).isEqualTo(carNames.size());
    }
}
