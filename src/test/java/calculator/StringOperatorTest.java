package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringOperatorTest {

    @Test
    @DisplayName("기본 구분자를 기준으로 문자열분할 테스트")
    void 기본_구분자() {
        final String target = "1,2:3";
        final StringOperator stringOperator = new StringOperator(target);
        assertThat(stringOperator.split())
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자가 포함되어있을때 문자열분할 테스트")
    void 커스텀_구분자() {
        final String target = "//%\n1,2:3%10";
        final StringOperator stringOperator = new StringOperator(target);
        assertThat(stringOperator.split())
                .containsExactly("1", "2", "3", "10");
    }
}
