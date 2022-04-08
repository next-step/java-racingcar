package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CaculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 가지는 문자열 전달시 구분자를 기준으로 분리한 각 숫자의합을 반환한다")
    @Test
    void separator() {
        assertThat(Caculator.input("1,2")).isEqualTo(3);
        assertThat(Caculator.input("1,2,3")).isEqualTo(6);
        assertThat(Caculator.input("1,2:3")).isEqualTo(6);
        assertThat(Caculator.input("7,2")).isEqualTo(9);
        assertThat(Caculator.input("1,2:3:2:1:1")).isEqualTo(10);
    }

    @DisplayName("문자열이 비어있거나 null 이라면 0을 반환한다")
    @Test
    void emptyValueIsZero() {
        assertThat(Caculator.input("")).isEqualTo(0);
        assertThat(Caculator.input(null)).isEqualTo(0);
    }

    @DisplayName("// 와 \n 사이에 위치하는 문자를 커스텀 구분자로 지정할 수 있다")
    @Test
    void customSeparator() {
        assertThat(Caculator.input("//;\n1;2;3")).isEqualTo(6);
        assertThat(Caculator.input("//_\n1_2_2")).isEqualTo(5);
        assertThat(Caculator.input("//=\n1=2=3=5")).isEqualTo(11);
    }

    @DisplayName("숫자 이외의 값 또는 음수는 RuntimeException 이 발생한다")
    @Test
    void exceptionInputString() {
        assertThatThrownBy(() -> Caculator.input("1,-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수값");

        assertThatThrownBy(() -> Caculator.input("s,2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아니다");

        assertThatThrownBy(() -> Caculator.input("//;\n1;2;d"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아니다");
    }

}
