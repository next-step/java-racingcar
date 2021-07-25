package racing.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingUtilsTest {

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

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    @DisplayName("랜덤값 유효성 범위를 벗어나는 경우 예외 테스트")
    void checkRandomNumber(int number) {
        assertThatThrownBy(
                () ->   RacingUtils.checkRandomNumber(number)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}