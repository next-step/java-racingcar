package autoracing;

import autoracing.domain.RacingGame;
import autoracing.domain.RandomRacingRule;
import autoracing.view.InputView;
import autoracing.view.ResultView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RacingGameIntegrationTest {
    @ParameterizedTest
    @CsvSource(value = {"Mercedes,Ferrari,Lamborghini,McLaren,Ford,Lenault:4:10:4"}, delimiter = ':')
    public void racingGame(String numberOfCars, Integer totalRounds, int ruleBound, int ruleThreshold) {
        String inputValues = numberOfCars + "\n" + totalRounds.toString() + "\n";
        InputStream inputStream = new ByteArrayInputStream(inputValues.getBytes());
        InputView input = InputView.takeInput(inputStream);

        RacingGame game = new RacingGame(
                input.getTotalRounds(),
                input.getCars()
        );

        game.setRule(new RandomRacingRule(ruleBound, ruleThreshold));
        game.start();

        ResultView resultView = new ResultView.Builder(game).build();
        resultView.show();
    }
}
