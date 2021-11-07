package study02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MyNumberTest {

    @Test
    @DisplayName("Number 객체 생성")
    void create() {
        assertThat(new MyNumber("5")).isEqualTo(new MyNumber(5));
    }

    @Test
    @DisplayName("덧셈 계산")
    void 덧셈() {
        assertThat(new MyNumber("2").plus(new MyNumber(3))).isEqualTo(new MyNumber(5));
    }

    @Test
    @DisplayName("뺄셈 계산")
    void 뺄셈() {
        assertThat(new MyNumber("1").minus(new MyNumber(2))).isEqualTo(new MyNumber("-1"));
    }

    @Test
    @DisplayName("곱셈 계산")
    void 곱셈() {
        assertThat(new MyNumber("1").times(new MyNumber(2))).isEqualTo(new MyNumber(2));
    }

    @Test
    @DisplayName("나눗셈 계산")
    void 나눗셈_01() {
        assertThat(new MyNumber("4").dividedBy(new MyNumber(2))).isEqualTo(new MyNumber(2));
    }

    @Test
    @DisplayName("나눗셈 예외처리")
    void 나눗셈_02() {
        assertThatIllegalArgumentException().isThrownBy(() -> new MyNumber("4").dividedBy(new MyNumber(0)));
    }
}