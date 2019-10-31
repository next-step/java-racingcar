package step2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import step2.domain.CarDistanceGenerator;
import step2.domain.EqualCarDistanceGenerator;
import step2.domain.GameResult;
import step2.domain.GameRunner;

import static org.assertj.core.api.Assertions.assertThat;

class GameRunnerTest {
    @Test
    void makeGameResult() {
        final int tryTimes = 99;
        final int numberOfCars = 3;
        final String carNames = "pobi,crong,honux";
        final CarDistanceGenerator generator = new EqualCarDistanceGenerator(5);

        final GameResult result = GameRunner.builder()
                                            .carNames(Arrays.asList(carNames.split(",")))
                                            .tryTimes(tryTimes)
                                            .carDistanceGenerator(generator)
                                            .build().simulate();

        assertThat(result.getNumberOfPhases()).isEqualTo(tryTimes);
        assertThat(result.getNumberOfCars()).isEqualTo(numberOfCars);
    }
}