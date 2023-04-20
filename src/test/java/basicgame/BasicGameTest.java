package basicgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

        basicGame.startGame(carNameInput, actualTryCount);

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

        assertThatThrownBy(() -> basicGame.startGame(carNameInput, tryCount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ERROR_MESSAGE);
    }
}
