package StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("Calculator String WhiteSpace Exception Test")
    void WhiteSpaceExceptionTest() {
        assertThatThrownBy(() -> {
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression("         ");
            stringCalculator.arithmeticExpressionValidation(arithmeticExpression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Calculator String Null Exception Test")
    void NullExceptionTest() {
        assertThatThrownBy(() -> {
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression(null);
            stringCalculator.arithmeticExpressionValidation(arithmeticExpression);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Calculator Non Permitted Literal Exception Test")
    void LiteralExceptionTest() {
        assertThatThrownBy(() -> {
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression("2 + 3 + r + ㄱ");
            stringCalculator.arithmeticExpressionValidation(arithmeticExpression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Calculator Not Proper Expression Literal Exception Test")
    void NotProperExceptionTest() {
        assertThatThrownBy(() -> {
            ArithmeticExpression arithmeticExpression = new ArithmeticExpression("+ 2 + 3 + 4");
            stringCalculator.arithmeticExpressionValidation(arithmeticExpression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Calculator Plus Unit Test")
    void plusUnitTest() {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("3 + 3");
        assertThat(stringCalculator.calculate(arithmeticExpression)).isEqualTo(6);
    }

    @Test
    @DisplayName("Calculator Minus Unit Test")
    void minusUnitTest() {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("3 - 3");
        assertThat(stringCalculator.calculate(arithmeticExpression)).isEqualTo(0);
    }

    @Test
    @DisplayName("Calculator Minus Unit Test")
    void multiplyUnitTest() {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("3 * 3 * 3");
        assertThat(stringCalculator.calculate(arithmeticExpression)).isEqualTo(27);
    }

    @Test
    @DisplayName("Calculator Division Unit Test")
    void divisionUnitTest() {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("1024 / 2");
        assertThat(stringCalculator.calculate(arithmeticExpression)).isEqualTo(512);
    }

    @Test
    @DisplayName("Calculator Calculate Unit Test")
    void CalculateUnitTest() {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression("2 + 3 * 4 / 2");
        assertThat(stringCalculator.calculate(arithmeticExpression)).isEqualTo(10);
    }
}
