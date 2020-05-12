package step2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.ReflectionUtils;
import step1.StringCalculator;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("String이 연산자별로 잘 parsing되는지 확인")
    void parseParameter() {
        //given
        String test1 = "1 + 23 * 456 / 78";

        //when
        String[] results = stringCalculator.parseParameter(test1);

        //then
        assertThat(results).containsExactly("1","+","23","*","456","/","78");
    }

    @ParameterizedTest
    @CsvSource({"1 + 2,3","2 + 3 * 4 / 2,10","3 - 3 + 4 * 5 / 4,5","10 + 10 / 20 + 30 * 2,62"})
    void calculate(String input, String expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(Integer.valueOf(expected));

    }

    @DisplayName("사칙연산 operator가 맞는지 확인")
    @ParameterizedTest
    @CsvSource({"+,true","-,true","*,true","/,true","a,false","1,false","&,false"})
    void isValidFourArithmeticOperator(String input, String expected) {
        //when & then
        assertThat(stringCalculator.isValidFourArithmeticOperator(input)).isEqualTo(Boolean.valueOf(expected));
    }

    @Test
    @DisplayName("null parameter일 경우 IllegalArgumentException throw 하는지 확인")
    void isValidParameter_null() {
        //given
        String[] parameter = {null};

        //when&then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.assertValidParameter(parameter));
    }

    @Test
    @DisplayName("empty string parameter일 경우 IllegalArgumentException throw 하는지 확인")
    void isValidParameter_emptyString_throw_IllegalArgumentException() {
        //given
        String[] parameter = {" ", "  "};

        //when&then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.assertValidParameter(parameter));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 parameter일 경우 IllegalArgumentException throw 하는지 확인")
    void isValidParameter_invalidOperator_throw_IllegalArgumentException() {
        //given
        String[] parameter = {"1","+","2","&","3"};

        //when&then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.assertValidParameter(parameter));
    }

    @Test
    @DisplayName("숫자자리에 숫자가 존재하지않는 parameter의 경우 IllegalArgumentException throw 하는지 확인")
    void isValidParameter_invalid_digit() {
        //given
        String[] parameter = {"+","1","+","2"};

        //when&then
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.assertValidParameter(parameter));
    }

    @Test
    @DisplayName("정상적인 parameter 확인")
    void isValidParameter() {
        //given
        String[] parameter = {"1","+","23","*","456","/","78"};

        //when&then
        assertThat(stringCalculator.assertValidParameter(parameter))
            .isTrue();
    }

    private static Stream<Arguments> invalidParameter() {
        return Stream.of(
            Arguments.of(new String[]{"1","+","23","*","456","/","78"}, "true"),
            Arguments.of(new String[]{"123","/","45","*","6","/","7"}, "true")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidParameter")
    @DisplayName("MethodSource를 이용한 assertValidParameter 테스트")
    void isValidParameter(String[] input, String expected) {
        //when&then
        assertThat(stringCalculator.assertValidParameter(input))
            .isTrue();
    }

    @ParameterizedTest
    @CsvSource({"4,2,2","1,1,1","0,1,0","1,0,0"})
    @DisplayName("나눗셈 함수 테스트")
    void doDivision(String leftOperand, String rightOperand, String expected) {
        //when&then
        assertThat(stringCalculator
            .doDivision(Integer.valueOf(leftOperand),Integer.valueOf(rightOperand)))
            .isEqualTo(Integer.valueOf(expected));
    }

}