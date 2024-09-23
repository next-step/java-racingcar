import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void whenEmptyGivenReturnZero() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }
}
