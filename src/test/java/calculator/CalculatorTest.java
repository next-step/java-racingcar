package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @DisplayName("연산기호가 잘 들어왔는지 테스트")
    @Test
    void operationChek(){

    }

    @DisplayName("연산기호,숫자의 갯수가 맞는지 테스트")
    @Test
    void inputTest(){

    }

    @DisplayName("연산기호에 따라 결과가 잘나오는지 테스트")
    @Test
    @ParameterizedTest
    @EnumSource(value = Calculator.Operation.class, names = {"ADD","SUB"})
    void operateTest(){

    }

}