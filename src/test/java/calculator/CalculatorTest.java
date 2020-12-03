package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 4 * 2=10" ,
            "5 - 2 * 2 / 3=2" ,
            "9 / 5 + 2=3"
    }, delimiter = '=')
    @DisplayName("입력 문자열을 통한 사칙 연산 수행")
    public void calculate(String formula, int expected){
        //when
        int result = Calculator.calculate(formula);
        
        //then
        assertEquals(result, expected);
    }
}
