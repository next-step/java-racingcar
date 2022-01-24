package calculator.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionUtilTest {

    @Test
    @DisplayName("연산식 기호 분리 테스트")
    void expressionIntoSymbolsTest() {
        List<String> result = ExpressionUtil.split("6 / 2 + 3");

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(0)).isEqualTo("6");
        assertThat(result.get(1)).isEqualTo("/");
        assertThat(result.get(2)).isEqualTo("2");
        assertThat(result.get(3)).isEqualTo("+");
        assertThat(result.get(4)).isEqualTo("3");
    }
}