package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void shouldCreateCars() {
        List<String> carNames = Arrays.asList("Mercedes", "Ferrari", "Lamborghini", "McLaren");
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        int numberOfCars = cars.size();
        int totalRounds = 5;
        RacingRule rule = () -> true;

        RacingGame game = new RacingGame(totalRounds, cars);
        game.setRule(rule);

        assertThat(game).isNotNull()
                .extracting("totalRounds")
                .containsExactly(totalRounds);

        assertThat(game).extracting("participants")
                .flatExtracting((participants) -> (List<Car>) participants)
                .doesNotContainNull()
                .hasSize(numberOfCars)
                .filteredOn("rule", rule)
                .hasSize(numberOfCars);
    }
}
