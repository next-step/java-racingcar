package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest
    @EmptySource
    public void 빈문자(String input) {
        generateUserInput(input);
        assertThatThrownBy(() -> StringCalculator.calculateInputText())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력형태에 맞게 입력해주세요.");
    }

    @ParameterizedTest(name = "[{index}] 1,2,3 - {0}_calculate = {1}")
    @CsvSource(value = {"1,2,3 +:6", "1,2,3 -:-4", "1,2,3 *:6", "1,2,3 /:0"}, delimiter = ':')
    public void 모든연산자_계산(String input, int expectResult) {
        generateUserInput(input);
        int result = StringCalculator.calculateInputText();
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest(name = "[{index}] 1,2:3 - {0}_calculate = {1}")
    @CsvSource(value = {"1,2:3 +|6", "1,2:3 -|-4", "1,2:3 *|6", "1,2:3 /|0"}, delimiter = '|')
    public void 쉼표_또는_콜론_구분자_모든연산자_계산(String input, int expectResult) {
        generateUserInput(input);
        int result = StringCalculator.calculateInputText();
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3 +"})
    public void custom_구분자(String input) {
        generateUserInput(input);
        int result = StringCalculator.calculateInputText();
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3 +"})
    public void negative_불가(String input) throws Exception {
        generateUserInput(input);
        assertThatThrownBy(() -> StringCalculator.calculateInputText())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 들어올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,0 /"})
    public void 연산자_DIVIDE_ZERO_분모불가(String input) throws Exception {
        generateUserInput(input);
        assertThatThrownBy(() -> StringCalculator.calculateInputText())
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로는 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4 +", "//;\n25;5;5;5 -", "//%\n1%5%2%1 *"})
    public void 문자열_입력받아_계산(String input) throws Exception {
        generateUserInput(input);
        int result = StringCalculator.calculateInputText();
        assertThat(result).isEqualTo(10);
    }

    public static void generateUserInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}