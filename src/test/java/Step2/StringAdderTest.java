package Step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringAdderTest {

    private final StringAdder adder;

    StringAdderTest(){
        adder = new StringAdder();
    }

    /*
    * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    * (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    * */
    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "'1,2', 3",
            "'1,2,3', 6",
            "'1,2:3', 6"
    })
    void split_by_comma_or_colon(String input, int expected) {
        // act
        int res = adder.sum(input);

        // assert
        assertThat(res).isEqualTo(expected);
    }

    /*
    * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    * */
    @ParameterizedTest
    @CsvSource({"'//;\n1;2;3', 6"})
    void split_by_custom_delim(String input, int expected) {
        // act
        int res = adder.sum(input);

        // assert
        assertThat(res).isEqualTo(expected);
    }

    /*
    * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
    * */
    @ParameterizedTest
    @CsvSource({"'1,2,a', 'a,b,c', 'k'"})
    void throw_RuntimeException_when_number_not_provided(String input){
<<<<<<< HEAD
=======

>>>>>>> 7c25f2c (WIP: feat, test: add step 2)
        // act, assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> adder.sum(input));
    }

    /*
     * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     * */
    @ParameterizedTest
    @CsvSource({"'1,2,-3', '-1,-2,-3', '-5678'"})
    void throw_RuntimeException_when_negative_number_provided(String input){
        // act, assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> adder.sum(input));
    }
}
