package study.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.StringCalculator;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void calculate_empty() {
        int emptyResult = calculator.sum("");
        int nullResult = calculator.sum(null);

        assertThat(emptyResult).isEqualTo(0);
        assertThat(nullResult).isEqualTo(0);
    }

    @Test
    void calculate_single_operand() {
        int simpleResult = calculator.sum("2");
        int customizedTokenResult = calculator.sum("//;\n3");

        assertThat(simpleResult).isEqualTo(2);
        assertThat(customizedTokenResult).isEqualTo(3);
    }

    @Test
    void calculate_two_operand() {
        String firstTestStr = "1,2";
        String secondTestStr = "5:10";

        int firstResult = calculator.sum(firstTestStr);
        int secondResult = calculator.sum(secondTestStr);

        assertThat(firstResult).isEqualTo(3);
        assertThat(secondResult).isEqualTo(15);
    }

    @Test
    void calculate_multiple_operand() {
        String firstTestStr = "1,2,3";
        String secondTestStr = "5:10:15:20";

        int firstResult = calculator.sum(firstTestStr);
        int secondResult = calculator.sum(secondTestStr);

        assertThat(firstResult).isEqualTo(6);
        assertThat(secondResult).isEqualTo(50);
    }

    @Test
    void calculate_not_a_number() {
        String exceptionMessage = "must be a number";

        assertException("a,2", exceptionMessage);
        assertException("1:b", exceptionMessage);
        assertException("b,2,b", exceptionMessage);
        assertException("b:2:b", exceptionMessage);
        assertException("c:2,4", exceptionMessage);
    }

    private void assertException(String testStr, String exceptionMessage) {
        assertThatThrownBy(() -> calculator.sum(testStr))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining(exceptionMessage);
    }

    @Test
    void calculate_a_negative_number() {
        String exceptionMessage = "cannot be a negative number";

        assertException("-1,2", exceptionMessage);
        assertException("1:-5", exceptionMessage);
        assertException("-1,2,5", exceptionMessage);
        assertException("-1:2:5", exceptionMessage);
        assertException("5:-2,4", exceptionMessage);
    }

    @Test
    void calculate_customized_token_two_operand() {
        String firstTestStr = "//;\n1;2";
        String secondTestStr = "//.\n5.10";

        int firstResult = calculator.sum(firstTestStr);
        int secondResult = calculator.sum(secondTestStr);

        assertThat(firstResult).isEqualTo(3);
        assertThat(secondResult).isEqualTo(15);
    }

    @Test
    void calculate_customized_token_multiple_operand() {
        String firstTestStr = "//;\n1;2;3";
        String secondTestStr = "//.\n5.10.15.20";

        int firstResult = calculator.sum(firstTestStr);
        int secondResult = calculator.sum(secondTestStr);

        assertThat(firstResult).isEqualTo(6);
        assertThat(secondResult).isEqualTo(50);
    }

    @Test
    void calculate_customized_token_not_a_number() {
        String exceptionMessage = "must be a number";

        assertException("//;\na;2", exceptionMessage);
        assertException("//.\n1.b", exceptionMessage);
        assertException("//;\nb;2;b", exceptionMessage);
        assertException("//.\nc.2.4", exceptionMessage);
    }

    @Test
    void calculate_customized_token_a_negative_number() {
        String exceptionMessage = "cannot be a negative number";

        assertException("//;\n-1;2", exceptionMessage);
        assertException("//.\n1.-5", exceptionMessage);
        assertException("//;\n-1;2;5", exceptionMessage);
        assertException("//.\n5.-2.4", exceptionMessage);
    }
}
