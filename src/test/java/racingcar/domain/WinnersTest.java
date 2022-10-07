package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    void find_winners() {
        List<Car> cars = Arrays.asList(
                new Car("유민", 3),
                new Car("두유", 2)
        );
        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(new Car("유민", 3));
    }
}
