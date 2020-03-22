package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberVoTest {

    @DisplayName("0~9 사이의 정수값 반환 하는지 테스트")
    @Test
    public void createRandomNumber() throws Exception {
        //given
        int i = 0;

        //then
        while (i < 100) {
            assertThat(NumberVo.createRandomNumber()).isBetween(0, 9);
            i++;
        }
    }

    @DisplayName("값이 4 이상이면 true")
    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:false", "2:false", "4:true", "6:true", "10:true"}, delimiter = ':')
    public void isGreaterThan4(int num, boolean expect) throws Exception {
        //when
        boolean result = NumberVo.isGreaterThan4(num);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("값이 1 이상이면 true")
    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:false", "2:true", "4:true", "6:true", "10:true"}, delimiter = ':')
    public void isGreaterThan1(int num, boolean expect) throws Exception {
        //when
        boolean result = NumberVo.isGreaterThan1(num);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("입력값이 정수인지 : success")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "100:100"}, delimiter = ':')
    public void validateInteger_success(String input, int expect) throws Exception {
        //then
        assertThat(NumberVo.validateInteger(input)).isEqualTo(expect);
    }

    @DisplayName("입력값이 정수인지 : fail")
    @ParameterizedTest
    @ValueSource(strings = {"a", "@", "3.3"})
    public void validateInteger_fail(String input) throws Exception {
        //then
        assertThatThrownBy(() -> {
            NumberVo.validateInteger(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
