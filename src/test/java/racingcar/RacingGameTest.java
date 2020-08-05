package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private int numberOfCars;
    private int numberOfTrials;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        numberOfCars = 3;
        numberOfTrials = 5;
        GameInputs args = GameInputs.createUserArgs(numberOfCars, numberOfTrials);

        racingGame = RacingGame.createGame(args);
    }

    @DisplayName("게임 결과 테스팅")
    @Test
    void racingGameTest() {
        GameResults results = racingGame.start();

        assertThat(results.getSteps()).hasSize(numberOfTrials);
        assertThat(results.getSteps().get(0)).hasSize(numberOfCars);
    }
}