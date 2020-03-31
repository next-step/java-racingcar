package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.NegativeNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberUtilTest {

    @DisplayName("0~9 사이의 정수값 반환 하는지 테스트")
    @Test
    public void createRandomNumber() throws Exception {
        //given
        int i = 0;

        //then
        while (i < 100) {
            assertThat(NumberUtil.createRandomInt(9)).isBetween(0, 9);
            i++;
        }
    }

    @DisplayName("입력된 2개의 숫자 크기를 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:false", "2:1:true"}, delimiter = ':')
    public void compare(int num1, int num2, boolean expect) throws Exception {
        assertThat(NumberUtil.isGreaterThan(num1, num2)).isEqualTo(expect);
    }

    @DisplayName("String을 int로 변환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "10:10"}, delimiter = ':')
    public void validateIntegerAndReturn_success(String input, int expect) throws Exception {
        //then
        assertThat(NumberUtil.validateIntegerAndReturn(input)).isEqualTo(expect);
    }

    @DisplayName("숫자가 아닌 값을 숫자로 변환 하면 exception이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "---", "?", ","})
    public void validateIntegerAndReturn_fail(String input) throws Exception {
        //then
        assertThatThrownBy(() -> {
            NumberUtil.validateIntegerAndReturn(input);
        }).isInstanceOf(NegativeNumberException.class);
    }
}
