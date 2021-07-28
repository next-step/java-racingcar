package racing_winner.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommonUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    @DisplayName("랜덤값 유효성 범위를 벗어나는 경우 예외 테스트")
    void checkRandomNumber(int number) {
        assertThatThrownBy(
                () ->   CommonUtils.checkRandomNumber(number)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("해당 숫자가 경주 규칙-숫자가 4이상-에 따라 전진이 가능한지 확인")
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    void compareNumbers(int number, boolean expected) {
        boolean result = CommonUtils.compareNumber(number);
        assertThat(result).isEqualTo(expected);
    }

}