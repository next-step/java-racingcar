import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값 입력")
    void test1() {
        assertThat(Calculator.calculate(null)).isEqualTo(0);
        assertThat(Calculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력")
    void test2() {
        assertThat(Calculator.calculate("1")).isEqualTo(1);
        assertThat(Calculator.calculate("7")).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자 2개를 ','구분자로 입력")
    void test3() {
        assertThat(Calculator.calculate("1,7")).isEqualTo(8);
    }

    @Test
    @DisplayName("컴마, 콜론 구분자 사용")
    void test4() {
        assertThat(Calculator.calculate("1,3:5")).isEqualTo(9);
    }

    @Test
    @DisplayName("//\n로 구분자 입력")
    void test5() {
        assertThat(Calculator.calculate("//;\n1;6;8")).isEqualTo(15);
        assertThat(Calculator.calculate("//,:\n1,6:8")).isEqualTo(15);
    }

    @Test
    @DisplayName("음수 입력")
    void test6() {
        assertThatThrownBy(() -> {
            Calculator.calculate("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

}
