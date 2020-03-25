package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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


    @DisplayName("값이 1 이상이면 true")
    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:false", "2:true", "4:true", "6:true", "10:true"}, delimiter = ':')
    public void isGreaterThan1(int num, boolean expect) throws Exception {
        //when
        boolean result = NumberUtil.isGreaterThan1(num);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("String을 int로 변환, 반환, 검증 : success")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "10:10"}, delimiter = ':')
    public void validateIntegerAndReturn_success(String input, int expect) throws Exception {
        //then
        assertThat(NumberUtil.validateIntegerAndReturn(input)).isEqualTo(expect);
    }

    @DisplayName("String을 int로 변환, 반환, 검증 : fail")
    @ParameterizedTest
    @ValueSource(strings = {"a", "---", "?", ","})
    public void validateIntegerAndReturn_fail(String input) throws Exception {
        //then
        assertThatThrownBy(() -> {
            NumberUtil.validateIntegerAndReturn(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
