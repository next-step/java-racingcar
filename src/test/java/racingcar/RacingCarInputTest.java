package racingcar;

import commons.Constant;
import controller.RacingGame;
import model.CarsProgress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarInputTest {

    RacingGame racingGame;

    @BeforeEach
    void beforeEach() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("입력한 값에 맞게 자동차 생성 확인")
    void checkNumberOfCarsInputValue() {
        CarsProgress carsProgress = new CarsProgress("3");

        assertThat(carsProgress.getCarsList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("양의 정수인 경우 예외처리 패스")
    void exceptionPassPositiveInt() {
        assertThat(racingGame.validationInputValue("3")).isEqualTo("3");
    }

    @Test
    @DisplayName("입력값이 0인 경우 예외처리")
    void exceptionHandlingZero() {
        assertThatThrownBy(() -> racingGame.validationInputValue("0"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Constant.ZERO_OR_NEGATIVE_NUMERIC_ERR_MSG);
    }

    @Test
    @DisplayName("입력값이 음수인 경우 예외처리")
    void exceptionHandlingNegativeNumeric() {
        assertThatThrownBy(() -> racingGame.validationInputValue("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Constant.ZERO_OR_NEGATIVE_NUMERIC_ERR_MSG);
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외처리")
    void exceptionHandlingNonNumeric() {
        assertThatThrownBy(() -> racingGame.validationInputValue("+"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Constant.NON_NUMERIC_ERR_MSG);
    }
}
