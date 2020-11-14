import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,3"})
    void testRacingGame(int numCars, int numSteps) {
        RacingGame racingGame = new RacingGame(RacingCarTest.regularRacingCarMovingRule());

        List<String> testCarNames = IntStream.range(0, numCars)
                .mapToObj(i -> "testcar" + i)
                .collect(Collectors.toList());

        ArrayList<RacingStep> result = racingGame.run(testCarNames, numSteps);

        for (int step = 0; step < numSteps; step++) {
            RacingStep racingStep = result.get(step);

            List<RacingStep.RacingCarNameAndPosition> carNameAndPositionList = racingStep.getCarNameAndPositionList();

            assertThat(carNameAndPositionList.size()).isEqualTo(numCars);

            int expectedCarPosition = RacingCar.INITIAL_POSITION + step;

            assertThat(carNameAndPositionList.stream()
                    .mapToInt(carNameAndPosition -> carNameAndPosition.getPosition())
                    .allMatch(carPosition -> carPosition == expectedCarPosition)).isTrue();
        }
    }

}
