package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

public class CalculatorTest {
    private static Calculator calculator;
    private static final String errMsg = "계산식을 입력해주세요.\n올바른 계산식을 입력해주세요.\n";
    OutputStream out;
    InputStream in;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 사칙연산_테스트() {

        String input = "1 + 2";
        String output = "3.0";

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        calculator.start();
        Assertions.assertThat(output).isEqualTo(out.toString());

    }

    @Test
    void 연산자_에러테스트() {

        String input = "1 + 2 k 3";

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        calculator.start();
        Assertions.assertThat(errMsg).isEqualTo(out.toString());

    }

    @Test
    void 입력_순서_에러테스트() {

        String input = "+ 1 +";

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        calculator.start();
        Assertions.assertThat(errMsg).isEqualTo(out.toString());
    }

}
