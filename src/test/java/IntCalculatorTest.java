import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class IntCalculatorTest {

    @DisplayName("생성자: 잘못된 입력이 들어오면 IllegalArgumentException 을 던진다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"1 +", "1 * 4 +"})
    void 생성자_에러_테스트_1(String calculateRequestLine) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new IntCalculator(calculateRequestLine));
    }

    @DisplayName("calculate: 왼쪽부터 차례로 입력을 계산한다.")
    @ParameterizedTest
    @CsvSource({"1 + 2,3", "1 * 3 + 5,8", "5 / 1,5", "-1 + -11 * 30,-360"})
    void calculateInOrderFromTheLeft(String request, int expected) {
        IntCalculator calculator = new IntCalculator(request);
        assertThat(calculator.calculateInOrderFromTheLeft()).isEqualTo(expected);
    }
}
