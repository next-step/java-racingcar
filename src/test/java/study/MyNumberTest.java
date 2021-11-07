package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyNumberTest {
    @DisplayName("입력값 타입 STRING INT 동일")
    @Test
    void 입력값_타입_STRING_INT_동일(){
        assertThat(new MyNumber("1").equals(new MyNumber((1))));
    }

    @DisplayName("덧셈")
    @Test
    public void 덧셈(){
        assertThat(new MyNumber("1").plus(new MyNumber("2"))).isEqualTo(new MyNumber((3)));
    }

    @DisplayName("뺄셈")
    @Test
    public void 뺄셈(){
        assertThat(new MyNumber("3").minus(new MyNumber("2"))).isEqualTo(new MyNumber((1)));
    }

    @DisplayName("곱셈")
    @Test
    public void 곱셈(){
        assertThat(new MyNumber("3").times(new MyNumber("2"))).isEqualTo(new MyNumber((6)));
    }

    @DisplayName("나눗셈")
    @Test
    public void 나눗셈(){
        assertThat(new MyNumber("4").dividedBy(new MyNumber("2"))).isEqualTo(new MyNumber((2)));
    }
}
