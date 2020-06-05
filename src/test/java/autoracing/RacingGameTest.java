package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingGameTest {
    private RacingRule rule;

    @Test
    public void shouldCreateCars() {
        List<String> carNames = Arrays.asList("Mercedes", "Ferrari", "Lamborghini", "McLaren");
        int numberOfCars = carNames.size();
        int totalRounds = 5;
        RacingRule rule = () -> true;
        RacingGame game = new RacingGame(carNames, totalRounds, rule);

        assertThat(game).isNotNull()
                .extracting("totalRounds")
                .containsExactly(totalRounds);

        assertThat(game).extracting("participants")
                .flatExtracting((cars) -> (List<Car>) cars)
                .doesNotContainNull()
                .hasSize(numberOfCars)
                .filteredOn("rule", rule)
                .hasSize(numberOfCars);
    }
}
