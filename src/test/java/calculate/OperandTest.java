package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @Test
    @DisplayName("숫자 배열 추출하고 합 구하기")
    void customSum() {

        Operand operand = new Operand("₩₩;\n1;2;3");
        StringAddCalculator.extractNumbers(operand);
        assertThat(operand.stringNumbers).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(operand.numbers).isEqualTo(new int[]{1, 2, 3});
        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(6);
    }

    @Test
    @DisplayName("일반 구분자와 숫자 입력 시, 합 구하기")
    void generalSum() {

        Operand operand = new Operand("1,2,3");
        StringAddCalculator.extractNumbers(operand);
        assertThat(operand.stringNumbers).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(operand.numbers).isEqualTo(new int[]{1, 2, 3});
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();
        assertThat(StringAddCalculator.sumOfNumbers(operand).sum).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 입력이 없는 경우 런타임에러")
    void testOnlyDelimiter() {

        Operand operand = new Operand("₩₩;\n");
        assertThat(StringAddCalculator.isNullOrEmpty(operand)).isFalse();

        assertThatThrownBy(() -> StringAddCalculator.extractNumbers(operand))
                .isInstanceOf(RuntimeException.class);
    }
}
