package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("splintAndAdd() 메소드에 null 혹은 빈 문자열이 입력되면 0을 반환한다")
    void split_and_add_return_0() {
        Integer sumByEmpty = calculator.splitAndSum("");
        assertThat(sumByEmpty).isEqualTo(0);

        Integer sumByNull = calculator.splitAndSum(null);
        assertThat(sumByNull).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndAdd() 메소드는 쉼표 또는 콜론을 구분자를 기준으로 분리한 각 수자의 합을 반환한다.")
    void split_and_add() {
        Integer sum = calculator.splitAndSum("1:2,3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정해서 문자열을 자른 후 더할 수 있다")
    void split_and_add_by_custom_delimiter() {
        Integer sum = calculator.splitAndSum("//;\n1;2;3;");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndAdd() 메소드는 문자값이 전달되면 NumberFormatException을 던진다")
    void split_and_add_throw_NumberFormatException() {
        assertThatThrownBy(() -> {
            calculator.splitAndSum("a:e:d");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("splitAndAdd() 메소드는 음수값이 전달되면 IllegalArgumentException을 던진다")
    void split_and_add_throw_IllegalArgumentException(){
        assertThatThrownBy(() -> {
            calculator.splitAndSum("-1:2:5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 포함할 수 없습니다.");
    }
}