package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringSumCalculator.*;


public class StringSumCalculatorTest {

//    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
//    앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
//    문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

    @ParameterizedTest
    @DisplayName("쉼표(,) 또는 콜론(:)으로 구분하는 테스트")
    @ValueSource(strings = {"1,2,3", "1:2,3", "1:2:3"})
    void splitWithBothCommaAndColonTest(String value){
        String[] actual = splitWithCommmaAndColon(value);
        String expectedComponent1 = "1";
        String expectedComponent2 = "2";
        String expectedComponent3 = "3";
        assertThat(actual).contains(expectedComponent1, expectedComponent2, expectedComponent3);
    }

    @Test
    @DisplayName("문자열 수자 변환 테스트")
    void parseStringToIntTest(){
        String value = "2";
        int actual = parseStringToInt(value);
        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열이 \"\"일때 0 반환 테스트")
    @ValueSource(strings = {"", "  "})
    void emptyReturnZeroTest(String value){
        int actual = emptyReturnZero(value);
        assertThat(actual).isZero();
    }

    @Test
    @DisplayName("합산 테스트")
    void sumTest(){
        int[] valueArray = {1,2,3};
        int actual = sum(valueArray);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customDelimiterTest(){
        String value = "//;\n1;2;3";
        String actual = getCustomDelimiter(value);
        String expected = ";";
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 테스트")
    @ValueSource(strings = {"-1", "안", "hi"})
    void unavailableInputFailTest(String value){
        assertThatThrownBy(() -> {
            StringSumCalculator.checkInputAvailable(value);
        }).isInstanceOf(RuntimeException.class);
    }
}
