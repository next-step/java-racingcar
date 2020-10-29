package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("expression token validation 테스트")
public class ExpressionTokenValidatorTest {
    private ExpressionTokenValidator validator = new ExpressionTokenValidator();

    @Test
    @DisplayName("홀수 위치의 문자가 숫자로 변환될 수 없는 경우 IllegalArgumentException throw")
    public void tokenShouldBeNumberAtOddIndex() {
        assertThatThrownBy(() -> {
            validator.validate(new String[]{"+", "1", "sdjfk"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be number");
    }

    @Test
    @DisplayName("짝수 위치의 문자가 연산기호가 아닌경우 IllegalArgumentException throw")
    public void tokenShouldBeOperatorAtOddIndex() {
        assertThatThrownBy(() -> {
            validator.validate(new String[]{"1", "sdjfklsd", "2"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be operator");
    }

    @Test
    @DisplayName("토큰 개수가 짝수일경우 IllegalArgumentException throw")
    public void tokenCountShouldBeOdd() {
        assertThatThrownBy(() -> {
            validator.validate(new String[]{"1", "+"});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be odd number");
    }
}