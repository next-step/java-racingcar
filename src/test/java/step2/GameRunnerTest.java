package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRunnerTest {
    @Test
    void makeGameResult() {
        final int tryTimes = 99;
        final int numberOfCars = 10;
        final CarDistanceGenerator generator = new EqualCarDistanceGenerator(5);

        final GameResult result = new GameRunner(tryTimes, numberOfCars, generator).simulate();

        assertThat(result.getNumberOfPhases()).isEqualTo(tryTimes);
        assertThat(result.getNumberOfCars()).isEqualTo(numberOfCars);
    }
}