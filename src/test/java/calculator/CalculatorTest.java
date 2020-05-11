package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3","2,2,4","-1,-5,-6"})
    void add(int a,int b,int expected) {
        int result = Calculator.add(a,b);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,-1","2,2,0","5,3,2"})
    void sub(int a,int b,int expected) {
        int result = Calculator.sub(a,b);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,2","2,2,4","0,2,0"})
    void mul(int a,int b,int expected) {
        int result = Calculator.mul(a,b);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value={"2,2,1","0,3,0","6,3,2"})
    void div(int a,int b, int expected) {
        int result = Calculator.div(a,b);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value={"3,0"})
    @DisplayName("0으로 나눌때 예외처리")
    void exceptionDiv(int a, int b) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.div(a,b);
        }).withMessage("0으로 나눌 수 없습니다.");
    }
}