package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveTest {
    @Test
    @DisplayName("생성자를 통한 객체비교")
    void createTest() {
        assertThat(new Positive("1")).isEqualTo(new Positive(1));
    }

    @ParameterizedTest
    @ValueSource(strings= "-1")
    @DisplayName("Positive 생성자에서의 음수 Exception 처리")
    void negativeNumberTest(String input) {
        assertThatThrownBy(() -> new Positive(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Positive에서 덧셈 메소드 활용")
    void plusTest() {
        Positive result = new Positive("1").plus(2);
        assertThat(result).isEqualTo(new Positive(3));
    }
}