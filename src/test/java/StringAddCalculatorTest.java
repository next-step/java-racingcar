import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
    @DisplayName("빈 문자 또는 null 입력 시 0을 반환한다.")
    @Test
    public void test1() {
        String input = "";
        int result_empty = StringAddCalculator.sum(input);
        assertThat(result_empty).isEqualTo(0);

        int result_null = StringAddCalculator.sum(null);
        assertThat(result_null).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    public void test2() {
        String input = "1";
        int result = StringAddCalculator.sum(input);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    public void test3() {
        String input = "1,2";
        int result = StringAddCalculator.sum(input);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    public void test4() {
        String input = "1:2";
        int result = StringAddCalculator.sum(input);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    public void test5() {
        String input = "//-\n2-1";
        int result = StringAddCalculator.sum(input);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException으로 예외 처리해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1:2", "//^\n2^-1"})
    public void test6(String input) {
        assertThatThrownBy(() -> StringAddCalculator.sum(input)).isInstanceOf(RuntimeException.class);
    }
}
