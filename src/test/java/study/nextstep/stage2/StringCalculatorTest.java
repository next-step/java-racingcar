package study.nextstep.stage2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 계산기 구현 테스트")
public class StringCalculatorTest {
    @Test
    @DisplayName("Digit Consume 정규표현식에 대한 테스트")
    public void testConsumeDigitRegex(){
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher("3.48+3.2");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("3.48");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("3.2");
    }

    @ParameterizedTest
    @CsvSource(value={"1+2=3", "2*4=8", "4-3=1", "6/3=2"}, delimiter='=')
    @DisplayName("간단한 사칙 연산에 대한 테스트")
    public void testSimpleArithmeticOperation(String expression, double expectedResult){
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expectedResult, within(0.001));
    }

    @ParameterizedTest
    @CsvSource(value = {"1.5+2.4=3.9", "4.8-1.2=3.6", "1.1*1.1=1.21", "4.8/4=1.2"}, delimiter = '=')
    @DisplayName("부동소수점 간단한 사칙 연산에 대한 테스트")
    public void testSimpleFloatingNumberArithmeticOperation(String expression, double expectedResult){
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expectedResult,within(0.001));
    }

    @ParameterizedTest
    @CsvSource(value = {"1+2+3+4=10", "10-1*3=27", "8/4+3=5"}, delimiter = '=')
    @DisplayName("연속된 사칙 연산에 대한 테스트")
    public void testContinuousArithmeticOperation(String expression, double expectedResult){
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expectedResult, within(0.001));
    }

    @ParameterizedTest
    @CsvSource(value = {"15 + 33 / 4=12", "12*4.5+12=66", "44/11+7=11"}, delimiter = '=')
    @DisplayName("두 자릿수 이상에 대한 긴 사칙연산 테스트")
    public void testLongAndContinuousArithmeticOperation(String expression, double expectedResult){
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expectedResult, within(0.001));
    }

    @Test
    @DisplayName("잘못된 연산기호에 대한 테스트")
    public void testWrongOperator(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> StringCalculator.calculate("3&4"));
    }

    @Test
    @DisplayName("비어있는 문자열에 대한 테스트")
    public void testNullOrEmptyString(){
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(null));
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(""));
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(" "));
    }
}
