import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class stringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("inputTest")
    @ParameterizedTest
    @ValueSource(strings = {"","++*/","12345",
                " 9 9 99 999 ",
                "1 /*++ 8 * 7",
                "+ + + + + + /,"})
    void enter(String param) {
        assertThatThrownBy(() -> {
            calculator.enter(param);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 올바르지 않습니다");
    }

    @DisplayName("calculiTest")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 - 2:2", "6 * 2:12", "8 / 4:2", "2 * 3 / 3 / 2:1", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String param, double expected) {
        calculator.enter(param);
        calculator.calculate();
        assertThat(calculator.getResult()).isEqualTo(expected);
    }

}

