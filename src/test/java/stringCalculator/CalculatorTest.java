package stringCalculator;

import static stringCalculator.Calculator.sumText;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("어떤 값도 들어오지 안은 경우에 대한 test")
    void test1() {
        assertThat(sumText("")).isZero();
        assertThat(sumText(null)).isZero();
    }

    @Test
    @DisplayName("하나의 숫자만 입력되었을 경우에 대한 test")
    void test2() {
        assertThat(sumText("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("두개 이상의 숫자가 입력되었을 경우에 대한 test")
    void test3() {
        assertThat(sumText("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("기본 구분자를 혼합해서 이용했을 때에 대한 test")
    void test4() {
        assertThat(sumText("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 이용하였을 때에 대한 test")
    void test5() {
        assertThat(sumText("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자가 아닌, 문자가 들어갔을 때에 대한 test")
    void test6() {
        assertThrows(RuntimeException.class, () -> {
            sumText("sample");
        });
    }

    @Test
    @DisplayName("음수가 들어갔을 때에 대한 test")
    void test7() {
        assertThrows(RuntimeException.class, () -> {
            sumText("-1,2,3");
        });
    }
}
