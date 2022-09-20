package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("안내된 소스 코드 테스트 - 값 일치 여부 확인")
    @CsvSource(
            delimiter = '|',
            nullValues = {"NULL"},
            value = {
                "''|0", "NULL|0",
                "1|1",
                "1,2|3",
                "1,2:3|6",
                "'//;\n1;2;3'|6",
            }
    )
    void basic(String input, int expected) {
        int result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("안내된 소스 코드 테스트 - 예외 발생 확인")
    void basicException() throws Exception {
        assertThatThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}