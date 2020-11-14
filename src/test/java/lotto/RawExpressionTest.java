package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RawExpressionTest {

    @DisplayName("null으로 생성할때 예외 발생 테스트")
    @Test
    public void test() {
        assertThatThrownBy(
                () -> {
                    RawExpression rawExpression = new RawExpression(null);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈값으로 생성할때 예외 발생 테스트")
    @Test
    public void test1() {
        assertThatThrownBy(
                () -> {
                    RawExpression rawExpression = new RawExpression("");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
