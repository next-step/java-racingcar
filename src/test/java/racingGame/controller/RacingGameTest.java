package racingGame.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.strategy.RandomMovementStrategy;
import racingGame.service.RacingGameService;
import racingGame.ui.input.ConsoleInputView;
import racingGame.ui.input.InputView;
import racingGame.ui.output.ConsoleOutputView;
import racingGame.ui.output.OutputView;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingGameTest {

    private InputView input;
    private OutputView output;
    private RacingGameService gameService;

    @BeforeEach
    void setUp() {
        input = new ConsoleInputView();
        output = new ConsoleOutputView();
        gameService = new RacingGameService(new RandomMovementStrategy());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 항상 객체를 생성한다.")
    void 생성자_성공_테스트() {
        assertDoesNotThrow(() -> new RacingGame(input, output, gameService));
    }

}
