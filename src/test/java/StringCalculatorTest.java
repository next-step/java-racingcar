
import charactercalculator.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 기능 요구사항
 *
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
 * (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 *
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
public class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void null_input_test(){
        StringCalculator target = new StringCalculator();
        Assertions.assertThat(target.calculate()).isEqualTo(0);
    }

    @Test
    void zero_comma_test(){
        StringCalculator target = new StringCalculator("");
        Assertions.assertThat(target.calculate()).isEqualTo(0);
    }

    @Test
    void one_two_test(){
        StringCalculator target = new StringCalculator("1,2");
        Assertions.assertThat(target.calculate()).isEqualTo(3);
    }

    @Test
    void one_two_three_test(){
        StringCalculator target = new StringCalculator("1,2:3");
        Assertions.assertThat(target.calculate()).isEqualTo(6);
    }

    @Test
    void minus_test(){
        StringCalculator target = new StringCalculator("-1,2:3");
        Assertions.assertThatThrownBy(() -> target.calculate())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("양수를 입력해야 합니다.");
    }

    @Test
    void custom_separator_test(){
        StringCalculator target = new StringCalculator("//;\n1;2;3");
        Assertions.assertThat(target.calculate()).isEqualTo(6);
    }
}

