package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    List<Car> cars;

    @BeforeEach
    void setup() {
        cars = Arrays.asList(
                new Car(() -> true, "a", 2),
                new Car(() -> true, "b", 1),
                new Car(() -> true, "c", 3),
                new Car(() -> true, "d", 3)
        );
    }

    @DisplayName("우승자 찾기")
    @Test
    void findWinners() {
        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners.contains(new Car(() -> true, "c", 3))).isTrue();
        assertThat(winners.contains(new Car(() -> true, "d", 3))).isTrue();
    }
}
