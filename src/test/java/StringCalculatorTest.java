import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:04 오후
 */
public class StringCalculatorTest {

    @ParameterizedTest
    //@ValueSource(strings = {"2 + 3"})
    //@ValueSource(strings = {"115 + 1000 * 187 - 237"})
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void test(String fourArithmeticOperations) {
        StringCalculator stringCalculator = new StringCalculator();

        String[] arguments = fourArithmeticOperations.split(" ");

        int length = arguments.length;
        int answer = Integer.parseInt(arguments[0]); // 첫 숫자 초기화
        int answer1 = stringCalculator.answer(arguments, length, answer);
        assertThat(answer1).isEqualTo(10);
    }

}
