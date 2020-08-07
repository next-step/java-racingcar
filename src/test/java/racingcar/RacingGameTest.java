package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private String[] nameOfCars;
    private int numberOfTrials;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        nameOfCars = new String[] {"pobi", "eesuel", "nextStep"};
        numberOfTrials = 5;
        GameInputs args = GameInputs.createGameInputs(nameOfCars, numberOfTrials);

        racingGame = RacingGame.createGame(args);
    }

    @DisplayName("게임 결과 테스팅")
    @Test
    void racingGameTest() {
        GameResults results = racingGame.start();

        // 최초 초기 상태 저장 + 1
        int expectedSize = numberOfTrials + 1;

        assertThat(results.getSteps()).hasSize(expectedSize);
        assertThat(results.getSteps().get(0)).hasSize(nameOfCars.length);
    }
}