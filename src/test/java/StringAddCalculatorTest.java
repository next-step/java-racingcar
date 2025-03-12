import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("null이나 빈 문자열 입력시 0을 반환하는지")
    public void shouldReturnZeroWhenInputIsNullOrEmpty() {
        int result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = stringAddCalculator.splitAndSum("");
        assertThat(result).isZero();

        result = stringAddCalculator.splitAndSum(" ");
        assertThat(result).isZero();

        result = stringAddCalculator.splitAndSum("   ");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환하는지")
    public void shouldReturnNumberWhenSingleNumberIsGiven() {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두 개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환하는지")
    public void shouldReturnSumWhenTwoNumbersAreCommaSeparated() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있는지")
    public void shouldSupportCommaOrColonAsDelimiter() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 았는지")
    public void shouldSupportCustomDelimiterBetweenSlashesAndNewline() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생하는지")
    public void shouldThrowRuntimeExceptionWhenNegativeNumberIsGiven() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
