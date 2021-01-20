package caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자 변환기 테스트")
public class ConverterTest {
    @DisplayName("숫자 문자열이 숫자로 잘 바뀌는지 확인")
    @Test
    void toDouble() {
        double result = Converter.toDouble("10.3");
        assertThat(result).isEqualTo(10.3);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열일 경우 IllegalArgumentException 발생")
    void toDoubleShouldThrowException() {
        assertThatThrownBy(
                () -> Converter.toDouble("STRING")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
