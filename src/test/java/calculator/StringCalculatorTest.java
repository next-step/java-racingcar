package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    /*

    * 요구사항
    * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
    *
     * */

//     * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
    @Test
    @DisplayName("빈문자열 또는 null 값 체크")
    void empty_and_null_check() {
        assertThat(StringCalculator.calculator("")).isEqualTo(0);
        assertThat(StringCalculator.calculator(null)).isEqualTo(0);
    }

//    * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    @Test
    @DisplayName("숫자 하나 문자열 입력시 해당 숫자 반환")
    void single_num_return_str(){
        assertThat(StringCalculator.calculator("1")).isEqualTo(1);
    }


//        * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자 입력시 합출력 ")
    void calculate_sum_split_comma(){
        assertThat(StringCalculator.calculator("1,2")).isEqualTo(3);
    }

//        * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
    @Test
    @DisplayName("숫자 두개를 콜론(:) 구분자 입력시 합출력 ")
    void calculate_sum_split_colon(){
        assertThat(StringCalculator.calculator("1,2:3")).isEqualTo(6);
    }

//        * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void custom_delimiter(){
        assertThat(StringCalculator.calculator("//;\\n1;2;3")).isEqualTo(6);
    }

//    * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void positive_number_check(){
        assertThatThrownBy(()->{
            StringCalculator.calculator("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
