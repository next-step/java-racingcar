import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("splitAndSum 메소드는 null 또는 빈문자가 입력 되었을때, 결과값은 '0'이 나와야 한다.")
    @Test
    public void splitAndSum_메소드_입력갑_검증_테스트() {
        int expected = StringAddCalculator.splitAndSum(null);
        assertThat(expected).isEqualTo(0);

        expected = StringAddCalculator.splitAndSum("");
        assertThat(expected).isEqualTo(0);
    }

}
