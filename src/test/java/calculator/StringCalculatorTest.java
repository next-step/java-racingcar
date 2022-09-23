package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void null_또는_빈문자(String input) {
        List<Integer> intListNull = StringCalculator.splitText(input);
        int calculateNull = StringCalculator.calculate(intListNull, Operator.PLUS);
        assertThat(calculateNull).isEqualTo(0);
    }

    @ParameterizedTest(name = "[{index}] 1,2,3 - {0}_calculate = {1}")
    @CsvSource(value = {"PLUS:6", "MINUS:-4", "MULTIPLY:6", "DIVIDE:0"}, delimiter = ':')
    public void 모든연산자_계산(Operator operator, int result) {
        List<Integer> intList = StringCalculator.splitText("1,2,3");
        int calculateNull = StringCalculator.calculate(intList, operator);
        assertThat(calculateNull).isEqualTo(result);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        List<Integer> intListNull = StringCalculator.splitText("1");
        int result = StringCalculator.calculate(intListNull, Operator.PLUS);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 쉼표구분자() throws Exception {
        List<Integer> intListNull = StringCalculator.splitText("1,2");
        int result = StringCalculator.calculate(intListNull, Operator.PLUS);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 쉼표_또는_콜론_구분자() throws Exception {
        List<Integer> intListNull = StringCalculator.splitText("1,2:3");
        int result = StringCalculator.calculate(intListNull, Operator.PLUS);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void custom_구분자() throws Exception {
        List<Integer> intListNull = StringCalculator.splitText("//;\n1;2;3");
        int result = StringCalculator.calculate(intListNull, Operator.PLUS);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void negative_불가() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitText("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 들어올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1/2,2,3", "1$3,4:5", "//%\n1%%2%%3"})
    public void 숫자형태가_아닌_값(String value) throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitText(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 형태가 아닌 값이 존재합니다.");
    }

    @Test
    public void 연산자_DIVIDE_ZERO_분모불가() throws Exception {
        List<Integer> intList = StringCalculator.splitText("1,0");
        assertThatThrownBy(() -> StringCalculator.calculate(intList, Operator.DIVIDE))
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