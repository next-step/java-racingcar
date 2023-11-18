package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorTest {

    @Test
    @DisplayName("콜론을 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한다.")
    void separate_with_column() {
        // given
        String given = "1:3";

        // when
        List<String> result = Separator.separate(given);

        // then
        assertThat(result).isEqualTo(List.of("1", "3"));
    }

    @Test
    @DisplayName("문자열 앞부분에 // 와 \n 사이의 문자를 커스텀 구분자로 사용한다.")
    void separate_with_custom_regex() {
        // given
        Calculator calculator = new Calculator();
        String given = "//&\n1&3";

        // when
        PositiveNumber result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(new PositiveNumber("4"));
    }
}
