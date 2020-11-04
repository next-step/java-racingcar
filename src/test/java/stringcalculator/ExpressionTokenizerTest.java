package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력된 문자열을 토큰으로 분리 클래스 테스트")
public class ExpressionTokenizerTest {

    @Test
    @DisplayName("스페이스 기준으로 분리되는지 확인")
    public void seperateWithSpace() {
        String[] tokens = ExpressionTokenizer.getTokens("1 2 3 4");

        assertThat(tokens).containsExactly("1", "2", "3", "4");
    }

    @Test
    @DisplayName("홀수 위치의 문자가 숫자로 변환될 수 없는 경우 IllegalArgumentException throw")
    public void tokenShouldBeNumberAtOddIndex() {
        assertThatThrownBy(() -> {
            ExpressionTokenizer.validate(new String[]{"+", "1", "sdjfk"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be number");
    }

    @Test
    @DisplayName("짝수 위치의 문자가 연산기호가 아닌경우 IllegalArgumentException throw")
    public void tokenShouldBeOperatorAtOddIndex() {
        assertThatThrownBy(() -> {
            ExpressionTokenizer.validate(new String[]{"1", "sdjfklsd", "2"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be operator");
    }

    @Test
    @DisplayName("토큰 개수가 짝수일경우 IllegalArgumentException throw")
    public void tokenCountShouldBeOdd() {
        assertThatThrownBy(() -> {
            ExpressionTokenizer.validate(new String[]{"1", "+"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be odd number");
    }
}