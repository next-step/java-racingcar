package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @Test
    @DisplayName("숫자 배열 추출하고 합 구하기")
    void customDelimiterSum() {

        Operand operand = new Operand("₩₩;\n1;2;3");
        StringAddCalculator.extractDelimiter(operand);
        StringAddCalculator.extractNumbers(operand);

        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(6);
    }

    @Test
    @DisplayName("일반 구분자와 숫자 입력 시, 합 구하기")
    void defaultDelimiterSum() {

        Operand operand = new Operand("1,2,3");
        StringAddCalculator.extractDelimiter(operand);
        StringAddCalculator.extractNumbers(operand);

        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 하나 입력 시 합 리턴")
    void oneInput() {

        Operand operand = new Operand("₩₩;\n1");
        StringAddCalculator.extractDelimiter(operand);
        StringAddCalculator.extractNumbers(operand);
        assertThat(operand.stringNumbers).isEqualTo(new String[]{"1"});
        assertThat(operand.numbers).isEqualTo(new int[]{1});
        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 입력이 없는 경우 런타임에러")
    void testOnlyDelimiter() {

        Operand operand = new Operand("₩₩;\n");
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();

        assertThatThrownBy(() -> StringAddCalculator.extractNumbers(operand))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수 포함 시 런타임에러")
    void negativeInput() {

        Operand operand = new Operand("₩₩;\n1;-2;3");
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();

        assertThatThrownBy(() -> StringAddCalculator.extractNumbers(operand))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("쉼표 및 콜론 구분자 포함한 문자열 입력 시 합 리턴")
    void variatyDelimiter() {

        Operand operand = new Operand("2:3,4");
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();

        StringAddCalculator.extractDelimiter(operand);
        StringAddCalculator.extractNumbers(operand);

        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(9);

    }
}
