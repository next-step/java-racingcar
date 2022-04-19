package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.RaceBuilderException;

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

    @Test
    void 자동차_이름_에러_테스트() {
        assertThatThrownBy(() -> {
            Race race = new Race.RaceBuilder()
                    .setCarNames(new ArrayList<>())
                    .setRaceCount(5)
                    .setCondition(new TrueCondition())
                    .build();
        }).isInstanceOf(RaceBuilderException.class)
                .hasMessageMatching("자동차 이름은 1개 이상 입력해야합니다.");
    }

    @Test
    void 경기회수_에러_테스트() {
        assertThatThrownBy(() -> {
            Race race = new Race.RaceBuilder()
                    .setCarNames(carNames)
                    .setRaceCount(0)
                    .setCondition(new TrueCondition())
                    .build();
        }).isInstanceOf(RaceBuilderException.class)
                .hasMessageMatching("경기 회수는 1 이상의 수를 입력해주세요");
    }
}
