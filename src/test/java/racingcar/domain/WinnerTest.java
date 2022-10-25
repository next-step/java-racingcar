package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    @Test
    @DisplayName("자동차 경주 우승자를 구한다.")
    void find_one_winner() {
        Cars endCars = Cars.of(
                new Car("A", 1),
                new Car("B", 0)
        );
        assertThat(Winners.find(endCars).getWinners()).contains(new Name("A"));
    }

    @Test
    @DisplayName("자동차 경주 우승자는 여러명일 수 있다.")
    void find_several_winner() {
        Cars endCars = Cars.of(
                new Car("A", 1),
                new Car("B", 1)
        );
        assertThat(Winners.find(endCars).getWinners()).contains(new Name("A"), new Name("B"));
    }
}
