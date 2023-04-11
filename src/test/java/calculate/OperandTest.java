package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @Test
    @DisplayName("일반 구분자 가진 입력에서 구분자 구하기")
    void extractGeneralDelimiter() {
        Operand operand = new Operand("1:2:3");
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();
        assertThat(operand.delimiter).isEqualTo(":");
    }

    @Test
    @DisplayName("커스텀 구분자 가진 입력에서 구분자 구하기")
    void extractCustomDelimiter() {
        Operand operand = new Operand("₩₩:\n1:2:3");
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();
        assertThat(operand.delimiter).isEqualTo(":");
    }

    @Test
    @DisplayName("숫자 배열 추출하기")
    void extractNumbersList() {

        Operand operand = new Operand("₩₩;\n1;2;3");
        StringAddCalculator.extractNumbers(operand);
        assertThat(operand.stringNumbers).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(operand.numbers).isEqualTo(new int[]{1, 2, 3});
        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 배열 넘겨서 합 구하기")
    void calculate() {

        String delimiter = ",|:";
        String input = "1:2:3";
        String[] numbers = input.split(delimiter);

        assertThat(numbers).isEqualTo(new String[]{"1", "2", "3"});
    }
}
