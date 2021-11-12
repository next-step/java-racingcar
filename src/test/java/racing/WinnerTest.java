package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.domain.Racing;
import racing.domain.Winner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class WinnerTest {

    @ParameterizedTest(name = "우승자")
    @MethodSource("racing.RacingTest#indexCarsAndResultProvider")
    void winner() {
        Racing racing = new Racing(Arrays.asList("1", "2", "3"), 3);
        Winner winner = new Winner();
        racing.play(new DeterministicRandom(), winner);
        List<Car> winners = winner.getWinners();
        assertThat(winners).extracting("name").contains("2", "3");
    }
}