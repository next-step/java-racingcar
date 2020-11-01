package study1.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    void setUp(){
        this.cal = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("입력값 검증 테스트")
    @ValueSource(strings = {"    ", ""})
    void isNullCheckTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ~ 1", "1 ! 2"})
    void calculateSymbolCheckTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "12 * 3 + 4 / 2:20", "1 + 1 + 1 + 1:4", "4 * 4:16"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, int result) {
        assertThat(cal.calculate(input)).isEqualTo(result);
    }
}
