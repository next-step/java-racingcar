package basicgame;

import basicgame.strategy.RandomActive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static basicgame.BasicGame.INPUT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BasicGameTest {


    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Success")
    void inputUiTestSuccess() {
        var expectedCarCount = 3;
        var expectedTryCount = 5;

        var actualTryCount = 5;

        Cars cars = new Cars();
        BasicGame basicGame = new BasicGame(cars);
        var carNameInput = "A,B,C";

        basicGame.startGame(carNameInput, actualTryCount, new RandomActive());

        assertThat(cars.getCars().size()).isEqualTo(expectedCarCount);
        assertThat(basicGame.triedCount.getValue()).isEqualTo(expectedTryCount);
    }

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Fail")
    void inputUiTestFailure() {
        var tryCount = 5;

        Cars cars = new Cars();
        BasicGame basicGame = new BasicGame(cars);
        var carNameInput = "";

        assertThatThrownBy(() -> basicGame.startGame(carNameInput, tryCount, new RandomActive())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ERROR_MESSAGE);
    }
}
