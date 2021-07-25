package racing.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingUtilsTest {

    @Test
    @DisplayName("random 숫자가 10 이하로 잘 출력되는지 확인")
    void randomNumber() {
        int randomNumber = RacingUtils.randomNumber();
        assertThat(randomNumber).isLessThanOrEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("해당 숫자가 경주 규칙-숫자가 4이상-에 따라 전진이 가능한지 확인")
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    void compareNumbers(int number, boolean expected) {
        boolean result = RacingUtils.compareNumbers(number);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("경주 횟수 및 자동차 대 수 입력값의 예외 출력 확인")
    @CsvSource(value = {"0:1", "1:0","0:0"}, delimiter = ':')
    void checkInputValue(int round, int car) {
        assertThatThrownBy(
                () ->  RacingUtils.checkInputValue(round, car)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}