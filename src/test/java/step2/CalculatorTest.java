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
    public void 입력_값이_null일_경우_IllegalArgumentException이_발생한다() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(null))
                .withMessageMatching("Value is null or empty");
    }

    @Test
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException이 발생한다")
    public void 입력_값이_빈_공백_문자일_경우_IllegalArgumentException이_발생한다() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(""))
                .withMessageMatching("Value is null or empty");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다")
    public void 사칙연산_기호가_아닌_경우_IllegalArgumentException이_발생한다() {
        //given
        String given = "1 + 2 $ 4";
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(given))
                .withMessageMatching("Unsupported Operation : \\$");
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능 구현 시 정상적으로 계산할 수 있다")
    public void 사칙_연산을_모두_포함하는_기능_구현_시_정상적으로_계산할_수_있다() {
        //given
        String given = "2 + 3 * 4 / 1 + 10";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(30);
    }
}
