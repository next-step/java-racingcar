package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeAll
    void setUp() {
        cal = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("샘플 데이터 테스트")
    @CsvSource(value = {
            "2 + 3 * 4 / 2=10",
            "2 + 3 - 4 * 5 / 2=2",
            "7 + 5 * 9 / 6=18",
            "9 + 6 * 3 / 5 + 1=10",
            "7 + 7 * 4 / 8=7",
    }, delimiter = '=')
    void sample_data_test(String text, int expected) {
        assertEquals(expected, cal.calculate(text));
    }

    @Test
    @DisplayName("NULL 또는 빈문자")
    void null_or_empty_test() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    cal.calculate("");
                }).withMessageMatching(StringCalculator.ERROR_MSG_BLANK);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.calculate(null);
        });
    }

    @Test
    @DisplayName("숫자_하나")
    void one_data_test() throws Exception {
        assertEquals(1, cal.calculate("1"));
    }

}