package racing.utils;

import static org.assertj.core.api.Assertions.assertThat;

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
    @CsvSource(value = {"1:false", "2:false", "4:true", "10:true"}, delimiter = ':')
    void compareNumbers(int number, boolean expected) {
        boolean result = RacingUtils.compareNumbers(number);
        assertThat(result).isEqualTo(expected);
    }
}