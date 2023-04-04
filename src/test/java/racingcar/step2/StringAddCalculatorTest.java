package racingcar.step2;

import com.nextstep.utils.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("빈문자열 또는 null 값을 입력할 경우 0을 반환한다")
    void splitAndSum_null_or_emptyText() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}