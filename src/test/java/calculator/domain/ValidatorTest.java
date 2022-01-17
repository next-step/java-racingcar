package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Test
    void 입력으로_공백이_들어옴_실패(){

        //given
        String userInput = " ";

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.validateUserInput(userInput));
    }

    @Test
    void 홀수번째는_숫자이다_성공() {

        // given
        String userInput = "1 + 3";

        // then
        assertDoesNotThrow(()->Validator.validateUserInput(userInput));
    }

    @Test
    void 홀수번째는_숫자이다_실패_숫자가아님() {

        // given
        String userInput = "/ + 3";

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.validateUserInput(userInput));
    }

    @Test
    void 홀수번째는_숫자이다_실패_공백여러개() {

        // given
        String userInput = "1 +  3";

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.validateUserInput(userInput));
    }

    @ValueSource(strings = {"+", "-", "*", "/"})
    @ParameterizedTest
    void 짝수번째는_연산자이다_성공(String op) {

        // given
        String userInput = "1 " + op + " 3";

        assertDoesNotThrow((()->Validator.validateUserInput(userInput)));
    }


    @Test
    void 짝수번째는_연산자이다_실패_연산자가_아님() {

        // given
        String userInput = "1 2 3";

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.validateUserInput(userInput));
    }
}