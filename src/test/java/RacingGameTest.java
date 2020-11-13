import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,3"})
    void testRacingGame(int numCars, int numSteps) {
        RacingGame racingGame = new RacingGame(RacingCarTest.regularRacingCarMovingRule());

        ArrayList<RacingStep> result = racingGame.run(numCars, numSteps);

        for (int step = 0; step < numSteps; step++) {
            RacingStep racingStep = result.get(step);
            List<Integer> carPositionList = racingStep.getCarPositionList();

            assertThat(carPositionList.size()).isEqualTo(numCars);

            int expectedCarPosition = RacingCar.INITIAL_POSITION + step;

            assertThat(carPositionList.stream()
                    .allMatch(carPosition -> carPosition == expectedCarPosition)).isTrue();
        }
    }

}
