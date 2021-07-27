package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        //given
        String given = "2 + 3";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        //given
        String given = "3 - 2";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        //given
        String given = "3 * 2";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗셈() {
        //given
        String given = "4 / 2";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException이 발생한다")
    public void 입력_값이_null일_경우_IllegalArgumentException이_발생한다(){
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(null));
    }

    @Test
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException이 발생한다")
    public void 입력_값이_빈_공백_문자일_경우_IllegalArgumentException이_발생한다(){
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(""));
    }
}
