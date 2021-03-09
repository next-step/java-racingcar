package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    public Calculator calculator;
    public Util util;

    @BeforeEach
    void initTest() {
        calculator = new Calculator();
        util = new Util();
    }

    @ParameterizedTest
    @CsvSource(value = {"+:false", "3:true", "&^%:false", "9821700182:true", "20.4:true"},
                delimiter = ':')
    void testNumberChecker(String str, boolean result) {
        assertThat(util.checkIsNumber(str)).isEqualTo(result);
    }


    @ParameterizedTest
    @ValueSource(strings = {"p y t h o n !"})
    @DisplayName("Test for string spliter in Util.class")
    void testStringSpliter(String value) {
        assertThat(util.splitStringWithBlank(value))
                .isEqualTo(new String[] {"p", "y", "t", "h", "o", "n", "!"});
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Test for invalid input data - null or empty string")
    void handleInvalidData(String value) {
        assertThatThrownBy(() -> {
            util.checkInvalidValue(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Value cannot be null or empty");
    }


    @ParameterizedTest
    @ValueSource(strings = {"^", "%", "#", "!", "@"})
    @DisplayName("Test for invalid operator")
    void handleInvalidOperator(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    util.checkInvalidOperator(value);
                }).withMessageMatching("Operator is invalid");
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for add function")
    void testAdd(int a, int b) {
        assertThat(calculator.add(a, b)).isEqualTo(a+b);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for subtract function")
    void testSubtract(int a, int b) {
        assertThat(calculator.subtract(a, b)).isEqualTo(a-b);
    }


    @ParameterizedTest
    @CsvSource(value = {"10:5", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for divide function")
    void testDivide(int a, int b) {
        assertThat(calculator.divide(a, b)).isEqualTo(a/b);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for multiply function")
    void testMultiply(int a, int b) {
        assertThat(calculator.multiply(a, b)).isEqualTo(a*b);
    }

}
