package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.ginsberg.junit.exit.ExpectSystemExit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Test
    void 입력으로_공백이_들어옴_실패() {

        //given
        String[] userInput = " ".split("\\s++");

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.validateUserInput(userInput));
    }

    @Test
    void 홀수번째는_숫자이다_성공() {

        // given
        String[] userInput = "1 + 3".split("\\s++");

        // then
        assertDoesNotThrow(() -> Validator.validateUserInput(userInput));
    }

    @Test
    void 홀수번째는_숫자이다_실패_숫자가아님() {

        // given
        String[] userInput = "/ + 3".split("\\s++");
        ;

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.validateUserInput(userInput));
    }

    @Test
    void 공백이_여러개여도_성공한다() {

        // given
        String[] userInput = "1 +  3".split("\\s++");

        // then
        assertDoesNotThrow(() -> Validator.validateUserInput(userInput));
    }

    @ValueSource(strings = {"+", "-", "*", "/"})
    @ParameterizedTest
    void 짝수번째는_연산자이다_성공(String op) {

        // given
        String str = "1 " + op + " 3";
        String[] userInput = str.split("\\s++");

        // then
        assertDoesNotThrow((() -> Validator.validateUserInput(userInput)));
    }


    @Test
    void 짝수번째는_연산자이다_실패_연산자가_아님() {

        // given
        String[] userInput = "1 2 3".split("\\s++");

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.validateUserInput(userInput));
    }

    @ExpectSystemExit
    @Test
    void q를_입력하면_종료된다() throws IOException {

        // given
        InputStream inputStream = new ByteArrayInputStream("q".getBytes());
        System.setIn(inputStream);

        // then
        Input.getUserInput();
    }

}