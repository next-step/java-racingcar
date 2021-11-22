package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @DisplayName("입력값 타입 STRING INT 동일")
    @Test
    void 입력값_타입_STRING_INT_동일(){
        assertThat(new Number("1").equals(new Number((1))));
    }

    @DisplayName("덧셈")
    @Test
    public void 덧셈(){
        assertThat(new Number("1").plus(new Number("2"))).isEqualTo(new Number((3)));
    }

    @DisplayName("뺄셈")
    @Test
    public void 뺄셈(){
        assertThat(new Number("3").minus(new Number("2"))).isEqualTo(new Number((1)));
    }

    @DisplayName("곱셈")
    @Test
    public void 곱셈(){
        assertThat(new Number("3").times(new Number("2"))).isEqualTo(new Number((6)));
    }

    @DisplayName("나눗셈")
    @Test
    public void 나눗셈(){
        assertThat(new Number("4").dividedBy(new Number("2"))).isEqualTo(new Number((2)));
    }
}
