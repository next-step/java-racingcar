package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈문자열 또는 null 값 체크")
    void empty_and_null_check() {
        assertThat(StringCalculator.calculator("")).isEqualTo(0);
        assertThat(StringCalculator.calculator(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 문자열 입력시 해당 숫자 반환")
    void single_num_return_str(){
        assertThat(StringCalculator.calculator("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자 입력시 합출력 ")
    void calculate_sum_split_comma(){
        assertThat(StringCalculator.calculator("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 콜론(:) 구분자 입력시 합출력 ")
    void calculate_sum_split_colon(){
        assertThat(StringCalculator.calculator("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void custom_delimiter(){
        assertThat(StringCalculator.calculator("//;\\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void positive_number_check(){
        assertThatThrownBy(()->{
            StringCalculator.calculator("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
