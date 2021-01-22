package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

public class CalculatorTest {
    private static Calculator calculator;
    private static final String inputMsg = "계산식을 입력해주세요.\n";
    private static final String errMsg = "계산식을 입력해주세요.\n올바른 계산식을 입력해주세요.\n";
    private static OutputStream out;
    private static InputStream in;
    private static final int NUMBER_OF_TESTCASE = 4;


    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
    }

    private static Stream<Arguments> provideExpressionAndAnswer() {
        return Stream.of(
                Arguments.of(1,"+",12, 13.0),
                Arguments.of(1,"-", 2, -1.0),
                Arguments.of(1,"*",5, 5.0),
                Arguments.of(1,"/",2, 0.5)
        );
    }

    @DisplayName("정상적인 계산식의 답안을 테스트")
    @ParameterizedTest
    @MethodSource("provideExpressionAndAnswer")
    void 사칙연산_테스트(double a,String op,double b,double result) {

        Assertions.assertThat(calculator.calculate(a, op, b)).isEqualTo(result);
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
