package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class CalculatorTest {
    private static Calculator calculator;
    private static final String inputMsg = "계산식을 입력해주세요.\n";
    private static final String errMsg = "계산식을 입력해주세요.\n올바른 계산식을 입력해주세요.\n";
    private static OutputStream out;
    private static InputStream in;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "'1 + 2', '3.0'",
            "'1 - 2', '-1.0'",
            "'1 * 2', '2.0'",
            "'1 / 2', '0.5'"
    })
    void 사칙연산_테스트(String input, String output) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        calculator.start();
        Assertions.assertThat(inputMsg + output).isEqualTo(out.toString());
    }

    @Test
    void 연산자_에러테스트() {

        String input = "1 + 2 k 3";

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        calculator.start();
        Assertions.assertThat(errMsg).isEqualTo(out.toString());

    }

    @Test
    void 입력_순서_에러테스트() {

        String input = "1 1 +";

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        calculator.start();
        Assertions.assertThat(errMsg).isEqualTo(out.toString());
    }

}
