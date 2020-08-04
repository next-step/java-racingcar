package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private int numberOfCars;
    private int numberfOfTrials;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        numberOfCars = 3;
        numberfOfTrials = 5;
        UserArguments args = UserArguments.createUserArgs(numberOfCars, numberfOfTrials);

        racingGame = RacingGame.createGame(args);
    }

    @DisplayName("게임 결과 테스팅")
    @Test
    void racingGameTest() {
        GameResults results = racingGame.start();

        assertThat(results.getSteps()).hasSize(numberfOfTrials);
        assertThat(results.getSteps().get(0)).hasSize(numberOfCars);
    }
}