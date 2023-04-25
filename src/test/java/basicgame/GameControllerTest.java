package basicgame;

import basicgame.controller.GameController;
import basicgame.service.strategy.RandomActive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static basicgame.controller.GameController.INPUT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameControllerTest {

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Success")
    void inputUiTestSuccess() {
        var expectedCarCount = 3;
        var expectedTryCount = 5;

        var actualTryCount = 5;

        GameController gameController = new GameController();
        var carNameInput = "A,B,C";

        gameController.startGame(carNameInput, actualTryCount, new RandomActive());

        assertThat(gameController.cars.getCars().size()).isEqualTo(expectedCarCount);
        assertThat(gameController.triedCount.getValue()).isEqualTo(expectedTryCount);
    }

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Fail")
    void inputUiTestFailure() {
        var tryCount = 5;

        GameController gameController = new GameController();
        var carNameInput = "";

        assertThatThrownBy(() -> gameController.startGame(carNameInput, tryCount, new RandomActive())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ERROR_MESSAGE);
    }
}
