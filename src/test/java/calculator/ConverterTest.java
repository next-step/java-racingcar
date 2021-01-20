package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {
    @DisplayName("숫자 문자열이 숫자로 잘 바뀌는지 확인")
    @Test
    void toDouble() {
        double result = Converter.toDouble("10.3");
        assertThat(result).isEqualTo(10.3);
    }

    @Test
    @DisplayName("Check toInt should throws exception with not number convertable string")
    void toDoubleShouldThrowException() {
        assertThatThrownBy(
                () -> Converter.toDouble("STRING")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
