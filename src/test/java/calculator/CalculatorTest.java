package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("getAnswer 테스트")
    public void getAnswerTest() {
        final Calculator calculator = new Calculator();
        assertThat(calculator.getAnswer("1 + 2")).isEqualTo(3);
        assertThatThrownBy(() -> calculator.getAnswer("asdfkljasdf")).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 식입니다.");
        assertThatThrownBy(() -> calculator.getAnswer("1 > 2")).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 식입니다.");
    }

}
