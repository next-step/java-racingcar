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
    void calculateTest(){
        assertThat(stringCalculator.calculate("1 + 2 - 3")).isEqualTo(0);
    }

    @Test
    void calculateTest_ShouldReturnIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(stringCalculator.calculate(""));
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

    @ParameterizedTest
    @CsvSource(value = "1,2")
    void plusTest(int first, int second){
        assertThat(stringCalculator.plus(first, second)).isEqualTo(3);
    }

    @Test
    void splitByWhiteSpaceTest(){
        String[] expected = new String[]{"1","+","2","+","3"};
        assertThat(stringCalculator.splitByWhiteSpace("1 + 2 + 3")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = "1,2")
    void minusTest(int first, int second){
        assertThat(stringCalculator.minus(first, second)).isEqualTo(-1);
    }

    @ParameterizedTest
    @CsvSource(value = "3,6")
    void multiplyTest(int first, int second){
        assertThat(stringCalculator.multiply(first, second)).isEqualTo(18);
    }

    @ParameterizedTest
    @CsvSource(value = "4,2")
    void divideTest(int first, int second) throws Exception {
        assertThat(stringCalculator.divide(first, second)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = "4,3")
    void divideTest_ShouldReturnCustomizedException(int first, int second) {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    stringCalculator.divide(first, second);
                }).withMessageMatching("나눗셈의 경우. 결과 값이 정수로 떨어지는 경우로 한정됩니다.");
    }

    @ParameterizedTest
    @CsvSource(value = "4,0")
    void divideTest_ShouldReturnArithmeticException(int first, int second) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    stringCalculator.divide(first, second);
                });
    }

}
