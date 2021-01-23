package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1+1",
            "2+2",
            "3+3"
    })
    void testWithCsvSource(String formula) {
        assertNotNull(formula);
    }

    @Test
    @DisplayName("getAnswer 테스트")
    public void getAnswerTest() {
        final Calculator calculator = new Calculator();
        assertThat(calculator.getAnswer("1 + 2")).isEqualTo(3);
        assertThat(calculator.getAnswer("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThatThrownBy(() -> calculator.getAnswer("asdfkljasdf")).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 식입니다.");
        assertThatThrownBy(() -> calculator.getAnswer("1 > 2")).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 식입니다.");
    }


}