package carrace.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("자동차 대수가 0이하의 값이면, 에러가 발생합니다.")
    @Test
    public void receiveCarNumTest_Negative() {
        int negativeNumCar = -1;
        assertThatThrownBy(() -> InputValidator.receiveCarNum(negativeNumCar))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 대수는 1대 이상의 값이면 아무 문제가 없습니다.")
    @Test
    public void receiveCarNumTest_Positive() {
        int positiveNumCar = 2;

        assertThat(InputValidator.receiveCarNum(positiveNumCar)).isEqualTo(positiveNumCar);
    }

    @DisplayName("시도 회수가 0 이하의 값이면, 에러가 발생합니다.")
    @Test
    public void receiveNumTryTest_Negative() {
        int negativeNumTry = -1;

        assertThatThrownBy(() -> InputValidator.receiveNumTry(negativeNumTry))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("시도 회수가 0 이하의 값이면, 에러가 발생합니다.")
    @Test
    public void receiveNumTryTest_Postive() {
        int positiveNumTry = 2;

        assertThat(InputValidator.receiveNumTry(positiveNumTry)).isEqualTo(positiveNumTry);
    }
}
