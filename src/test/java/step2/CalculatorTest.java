package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;

public class CalculatorTest {
    private String input;

    @BeforeEach
    void Setup() {
        input = "2 + 3 * 4 / 2";
    }

    // testValue = "2 + 3 * 4 / 2" 단위 테스트
    @Test
    void Test1() {
        Calculator calculator = new Calculator();
        String result;

        result = calculator.calculation(input);
        System.out.println(result);
        assertThat(result).isEqualTo("10");
    }

    // 공백이거나 null 값 경우 단위 테스트
    @Test
    void Test2() {
        assertThatIOException().isThrownBy(() -> {
            Calculator calculator = new Calculator();
            final String[] result = new String[1];
            result[0] = calculator.calculation(input);
            assertThat(result[0]).isEqualTo("10");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 여러 경우 테스트 실행
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 = 3 * 4 / 2:0", "     :0"}, delimiter = ':')
    void Test3(String inputValue, String expected) {
        Calculator calculator = new Calculator();
        final String[] result = new String[1];

        assertThatIOException().isThrownBy(() -> {
            result[0] = calculator.calculation(inputValue);
            assertThat(result[0]).isEqualTo(expected);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
