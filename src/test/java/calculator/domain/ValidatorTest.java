package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 홀수번째는_숫자이다_성공() {
        // given
        String userInput = "1 + 3";
        String[] split = userInput.split(" ");


        // then
        assertDoesNotThrow(()->Validator.oddIndexIsNumber(split));
    }

    @Test
    void 홀수번째는_숫자이다_실패_숫자가아님() {
        // given
        String userInput = "/ + 3";
        String[] split = userInput.split(" ");

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.oddIndexIsNumber(split));
    }

    @Test
    void 홀수번째는_숫자이다_실패_공백여러개() {
        // given
        String userInput = "1 +  3";
        String[] split = userInput.split(" ");
        System.out.println(split);

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.oddIndexIsNumber(split));
    }

    @Test
    void 짝수번째는_연산자이다_성공() {
        // given
        String userInput = "1 + 3";
        String[] split = userInput.split(" ");

        assertDoesNotThrow((()->Validator.evenIndexIsOperator(split)));
    }

    @Test
    void 짝수번째는_연산자이다_실패_연산자가_아님() {
        // given
        String userInput = "1 2 3";
        String[] split = userInput.split(" ");

        // then
        assertThrows(IllegalArgumentException.class, ()->Validator.evenIndexIsOperator(split));
    }
}