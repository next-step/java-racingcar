package Step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    public void sum()
    {
        String input = "";
        Assertions.assertThat(stringAddCalculator.sum(input)).isEqualTo(0);
        input = "1,2";
        Assertions.assertThat(stringAddCalculator.sum(input)).isEqualTo(3);
        input = "1,2,3";
        Assertions.assertThat(stringAddCalculator.sum(input)).isEqualTo(6);
        input = "1,2:3";
        Assertions.assertThat(stringAddCalculator.sum(input)).isEqualTo(6);

    }
}
