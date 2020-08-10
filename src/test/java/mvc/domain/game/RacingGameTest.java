package mvc.domain.game;

import mvc.domain.dto.GameSteps;
import mvc.domain.dto.GameInputs;
import mvc.domain.dto.GameResults;
import org.junit.jupiter.api.BeforeEach;
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
    
    @Test
    void 레이싱게임_결과_테스팅() {
        GameResults results = racingGame.startGame();

        // 최초 초기 상태 저장 + 1
        int expectedSize = numberOfTrials + 1;

        GameSteps steps = results.getSteps();

        assertThat(steps.getSteps()).hasSize(expectedSize);
    }
}