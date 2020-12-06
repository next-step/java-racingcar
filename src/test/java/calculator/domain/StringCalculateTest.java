package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculateTest {

    @DisplayName("null 체크")
    @ParameterizedTest
    @NullSource
    void nullExcpetion(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator(input);
        }).withMessageContaining("입력 값이 없습니다.");
    }

    @Test
    @DisplayName("빈칸 공백 여부 예외 처리")
    void isBlankException() {
        String input = "1 2 / 5";
        new StringCalculator(input);

        String input2 = "12/5";
        assertThat(input2.contains(" ")).isFalse();
        assertThat("1 2/5".contains(" ")).isTrue();
        assertThat("12 /5".contains(" ")).isTrue();
        assertThat("12/ 5".contains(" ")).isTrue();
        assertThat("12 / 5".contains(" ")).isTrue();
        assertThat("12/5 ".contains(" ")).isTrue();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator(input2);
        })
                .withMessageContaining("공백 구분자가 없습니다.");
    }

    @DisplayName("문자열 계산")
    @ParameterizedTest
    @CsvSource(value={"1 + 1 + 2 + 3,7", "1 + 3 / 2 * 4,8", "1 * 2 * 3 * 4 / 3 * 2 - 1,15", "5 / 1,5"
            , "1 + 2 + 4 * 3 / 6 / 8 * 123,0", "1 - 2,-1", "1 + 1 + 3 +5,2"})
    void calculate(String input, int expected) {
       StringCalculator calculator = new StringCalculator(input);
       int result = calculator.calculate();
       assertThat(result).isEqualTo(expected);
    }


    @DisplayName("입력값이 배열길이가 홀수인지, 처음과 마지막 값이 숫자인지 포맷 매치")
    @ParameterizedTest
    @ValueSource(strings = {"1+ 2", "1 + 2 //", "1+ 2+", "1 +", "1 1 +", "1 + 1 +"})
    void matchInputFormat(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator(input);
        })
                .withMessageContaining("입력값의 포맷이 맞습니다.");


    }

}
