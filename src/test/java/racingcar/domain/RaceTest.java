package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4})
    @DisplayName("입력한 횟수만큼 회차를 진행한다")
    void hasRoundResults(int rounds) {
        Car car = new Car(() -> true);
        Race race = new Race(List.of(car), rounds);

        List<List<Integer>> results = race.play();

        assertThat(results).hasSize(rounds);
    }

    @Test
    @DisplayName("입력한 횟수가 음수면 IllegalArgumentException")
    void canNotHaveNegativeRound() {
        Car car = new Car(() -> true);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Race(List.of(car), -1))
                .withMessage("rounds can not be negative value");
    }

    @Test
    @DisplayName("회차마다 각 차들은 전진할지 판단한다")
    void eachCarCanMoveByRound() {
        Car car1 = new Car(() -> true);
        Car car2 = new Car(() -> false);

        Race race = new Race(List.of(car1, car2), 3);

        List<List<Integer>> results = race.play();

        assertThat(results).containsExactly(List.of(1, 0), List.of(2, 0), List.of(3, 0));
    }
}
