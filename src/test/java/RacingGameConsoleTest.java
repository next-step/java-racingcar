import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameConsoleTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,3"})
    void testRacingStepToString(int numCars, int numForward) {
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < numCars; i++) {
            RacingCar racingCar = new RacingCar(RacingCarTest.regularRacingCarMovingRule(), i);

            for (int j = 0; j < numForward; j++) {
                racingCar.forward();
            }

            racingCars.add(racingCar);
        }

        RacingStep racingStep = new RacingStep(racingCars);

        assertThat(RacingGameConsole.racingStepToString(racingStep))
                .isEqualTo(buildExpectedRacingStepResult(numCars, numForward));
    }

    private String buildExpectedRacingStepResult(int numCars, int numForward) {
        return IntStream.range(0, numCars)
                .mapToObj(i -> String.join("", Collections.nCopies(RacingCar.INITIAL_POSITION + numForward, "-")))
                .collect(Collectors.joining("\n"));

    }

}
