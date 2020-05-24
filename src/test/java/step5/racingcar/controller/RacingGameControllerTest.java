package step5.racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.racingcar.view.InputView;
import step5.racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameControllerTest {

    @DisplayName("Controller 객체 생성 테스트")
    @Test
    public void makeRacingGameController() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        assertDoesNotThrow(() -> {
            RacingGameController racingGameController = new RacingGameController(inputView, resultView);
        });
    }

    @DisplayName("RacingGame 객체 없을 때 Controller Test 에러 발생")
    @Test
    public void throwExceptionWhenRacingGameIsNull() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingGameController racingGameController = new RacingGameController(inputView, resultView);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    racingGameController.startGame();
                });
    }
}
