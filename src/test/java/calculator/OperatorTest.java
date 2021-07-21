package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Nested
    @DisplayName("find operator")
    class FindOperatorTest {

        @DisplayName("plus operator")
        @Test
        void operatorPlusTest() {
            //given
            String plus = "+";

            //when
            Operator operator = Operator.findOperator(plus);

            //then
            assertThat(operator).isEqualTo(Operator.PLUS);
        }

        @DisplayName("minus operator")
        @Test
        void operatorMinusTest() {
            //given
            String plus = "-";

            //when
            Operator operator = Operator.findOperator(plus);

            //then
            assertThat(operator).isEqualTo(Operator.MINUS);
        }

        @DisplayName("multiply operator")
        @Test
        void operatorMultiplyTest() {
            //given
            String plus = "*";

            //when
            Operator operator = Operator.findOperator(plus);

            //then
            assertThat(operator).isEqualTo(Operator.MULTIPLY);
        }

        @DisplayName("divide operator")
        @Test
        void operatorDivideTest() {
            //given
            String plus = "/";

            //when
            Operator operator = Operator.findOperator(plus);

            //then
            assertThat(operator).isEqualTo(Operator.DIVIDE);
        }

    }

    @DisplayName("plus, minus, multiply, divide 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+, 12", "-, 8", "*, 20", "/,5"}, delimiter = ',')
    void operatorTest(String value, String result) {
        //given, when, then
        assertThat(Operator.findOperator(value).operate(10, 2)).isEqualTo(Integer.parseInt(result));
    }

}