package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

public class CalculatorTest {
    private static Calculator calculator;
    private static final String errMsg = "계산식을 입력해주세요.\n올바른 계산식을 입력해주세요.\n";
    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
    }

    @Test
    void getUserInput() {
        calculator.start();
        String[] testStrings = {"1", "+", "2"};
//        Assertions.assertThat(calculator.inputStrings).containsAll(testStrings);
    }

    @Test
    void 연산자_에러테스트() {

        String input = "1 + 2 k 3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        calculator.start();
        Assertions.assertThat(errMsg).isEqualTo(out.toString());

    }

}
