package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculateTest() throws Exception {
        assertThat(stringCalculator.calculate("1 + 2 - 3")).isEqualTo(0);
    }

    @Test
    void calculateTest_ShouldReturnCustomizedException(){
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            stringCalculator.calculate("4 / 3 + 3");
        }).withMessage("나눗셈의 경우. 결과 값이 정수로 떨어지는 경우로 한정됩니다.");
    }

    @Test
    void calculateTest_WhenOperatorIsNullThenIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(stringCalculator.calculate("1  2 + 3"));
        });
    }

    @Test
    void calculateTest_WhenOperatorNotExistsThenIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(stringCalculator.calculate("1 ^ 2 + 3"));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void isBlankTest_WhenBlankStringThenReturnTrue(String str){
        assertThat(stringCalculator.isBlank(str)).isTrue();
    }

    @Test
    void isBlankTest_WhenNullThenReturnTrue(){
        assertThat(stringCalculator.isBlank(null)).isTrue();
    }

    @Test
    void splitByWhiteSpaceTest(){
        String[] expected = new String[]{"1","+","2","+","3"};
        assertThat(stringCalculator.splitByWhiteSpace("1 + 2 + 3")).isEqualTo(expected);
    }

    @Test
    void calculateByOperatorTest() throws Exception {
        String[] input = new String[]{"1","+","2","/","3","-","1","*","100000"};
        assertThat(stringCalculator.calculateByOperator(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void convertStringToOperatorTest(String s, Operator o){
        assertThat(stringCalculator.convertStringToOperator(s)).isEqualTo(o);
    }

    @Test
    void convertStringToOperatorTest_ShouldReturnIllegalArgumentException(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.convertStringToOperator("^");
        });
    }
}
