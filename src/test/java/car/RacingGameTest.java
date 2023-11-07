package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new RandomNumberGenerator());
    }

    @BeforeEach
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"},delimiter = ':')
    public void 자동차_생성_테스트(Integer userInput, Integer numberOfCars) {
        assertThat(racingGame.createCars(userInput)).hasSize(numberOfCars);
    }
}
