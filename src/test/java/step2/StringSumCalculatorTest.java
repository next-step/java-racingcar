package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringSumCalculatorTest {

    // 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우,
    // 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_and_empty(String input) {
        int result = StringSumCalculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringSumCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringSumCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringSumCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringSumCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
