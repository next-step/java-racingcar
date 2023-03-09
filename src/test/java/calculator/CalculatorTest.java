package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullEnum;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @DisplayName("입력값이 없을때")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void inputValidateCheck(String input){
        Calculator calculator = new Calculator();
        assertThatThrownBy(()->calculator.inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("연산기호가 잘 들어왔는지 테스트")
    @Test
    void actualValidateCheck(){
        Calculator calculator = new Calculator();
        String input = "+/})";
        assertThatThrownBy(()->calculator.actualValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연산기호에 따라 결과가 잘나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "+:10",
            "*:16",
            "/:4",
            "-:6"
    }, delimiter = ':')
        void calculateTest(String operation,int result){
        Calculator calculator = new Calculator();
        calculator.calculate(8,2,operation);
        //assertThat(calculator.calculate(8,2,operation)).isEqualTo(result);
    }


}