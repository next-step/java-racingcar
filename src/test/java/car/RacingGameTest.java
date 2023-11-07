package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {
    private RacingGame racingGame;
    private final InputParser inputParser = new InputParser();

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new RandomNumberGenerator());
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:1", "pobi,crong:2", "pobi,crong,honux:3"},delimiter = ':')
    public void 자동차_생성_테스트(String userInput, Integer numberOfCars) {
        assertThat(racingGame.createCars(inputParser.parseUserInputByDelimiter(userInput))).hasSize(numberOfCars);
    }
}
