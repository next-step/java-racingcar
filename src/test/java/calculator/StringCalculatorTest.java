package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @BeforeAll
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("입력 문자열 공백으로 나누는 테스트")
    @CsvSource(value = {
            "2 + 3 - 4 * 8 / 2=9",
            "2 + 3 * 4 / 2=7",
            "7 + 5 * 9=5",
            "9 + 6=3",
            "7=1",
    }, delimiter = '=')
    void input_split_test(String text, int expected) {
        // when
        List<String> result = calculator.splitText(text);

        // then
        assertThat(result.size()).isEqualTo(expected);
    }
}

