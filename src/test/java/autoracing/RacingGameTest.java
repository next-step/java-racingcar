package autoracing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RacingGameTest {
    @Test
    public void shouldCreateCars() {
        List<Car> cars = makeCars("Mercedes", "Ferrari", "Lamborghini", "McLaren");
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

    @Test
    public void throwExceptionWhenBadArgumentWasPassedByConstructor() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(0, Arrays.asList(new Car("Audi")));
        }).withMessage("total rounds must be greater than zero.");

        assertThatNullPointerException().isThrownBy(() -> {
            new RacingGame(1, null);
        }).withMessage("participants must not be null.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingGame(1, Collections.emptyList());
        }).withMessage("the number of participants must be greater than zero.");
    }

    @Test
    public void shouldReturnedParticipantsThatHasDrivenLongestDistance() {
        List<Car> cars = makeCars("Mercedes", "Ferrari", "Lamborghini", "McLaren", "Renault", "Ford");
        RacingRule alwaysGo = () -> true;
        RacingRule neverGo = () -> false;
        setRuleToCars(cars, alwaysGo, 0, 2, 4);
        setRuleToCars(cars, neverGo, 1, 3, 5);
        int totalRounds = 6;

        RacingGame game = new RacingGame(totalRounds, cars);
        game.start();
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactly(cars.get(0), cars.get(2), cars.get(4));
        assertThat(winners.stream().map(winner -> winner.getLocation(totalRounds)))
                .extracting("distance")
                .containsOnly(totalRounds);
    }

    private List<Car> makeCars(String... carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    private void setRuleToCars(List<Car> cars, RacingRule rule, int... carNums) {
        Arrays.stream(carNums).forEach(num -> {
            cars.get(num).setRule(rule);
        });
    }
}
