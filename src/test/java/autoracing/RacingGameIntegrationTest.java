package autoracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RacingGameIntegrationTest {
    @ParameterizedTest
    @CsvSource({"3,4,10,4"})
    public void racingGame(Integer numberOfCars, Integer totalRounds, int ruleBound, int ruleThreshold) {
        String inputValues = numberOfCars.toString() + "\n" + totalRounds.toString() + "\n";
        InputStream inputStream = new ByteArrayInputStream(inputValues.getBytes());
        InputView input = InputView.takeInput(inputStream);

        RacingGame game = new RacingGame(
                input.getNumberOfCars(),
                input.getTotalRounds(),
                new RandomRacingRule(ruleBound, ruleThreshold)
        );

        game.start();
        game.replayResult();
    }
}
