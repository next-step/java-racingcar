package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class RaceTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4})
    @DisplayName("입력한 횟수만큼 회차를 진행한다")
    void hasRoundResults(int rounds) {
        Race race = new Race(List.of("pobi", "conan"), rounds, () -> 4);

        race.play();
        List<RoundResult> results = race.getRoundResults();

        assertThat(results).hasSize(rounds);
    }

    @Test
    @DisplayName("입력한 횟수가 음수면 IllegalArgumentException")
    void canNotHaveNegativeRound() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Race(List.of("pobi", "conan"), -1, () -> 4))
                .withMessage("rounds can not be negative value");
    }

    @Test
    @DisplayName("입력한 자동차 이름으로 자동차를 생성한다")
    void hasCars() {
        Race race = new Race(List.of("pobi", "conan"), 1, () -> 4);

        race.play();
        List<RoundResult> results = race.getRoundResults();

        assertThat(results.getFirst().carStatuses())
                .extracting(CarStatus::name)
                .containsExactly("pobi", "conan");
    }

    @Test
    @DisplayName("회차마다 각 차들은 전진할지 판단한다")
    void eachCarCanMoveByRound() {
        NumberGenerator alternating = new NumberGenerator() {
            private int count = 0;

            @Override
            public int generate() {
                if (count % 2 == 0) {
                    count++;
                    return 4;
                }
                count++;
                return 3;
            }
        };

        Race race = new Race(List.of("pobi", "conan"), 3, alternating);

        race.play();
        List<RoundResult> results = race.getRoundResults();

        assertThat(results)
                .isEqualTo(List.of(
                        new RoundResult(List.of(new CarStatus("pobi", 1), new CarStatus("conan", 0))),
                        new RoundResult(List.of(new CarStatus("pobi", 2), new CarStatus("conan", 0))),
                        new RoundResult(List.of(new CarStatus("pobi", 3), new CarStatus("conan", 0)))
                ));
    }

    @Test
    @DisplayName("경주는 한 번만 진행할 수 있다")
    void canNotPlayMoreThanOnce() {
        Race race = new Race(List.of("pobi", "conan"), 1, () -> 4);

        race.play();

        assertThatIllegalStateException().isThrownBy(race::play).withMessage("cannot play again");
    }
}
