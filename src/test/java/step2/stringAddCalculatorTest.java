package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class stringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    void null_또는_빈문자일경우() {
        int result = stringAddCalculator.splitAndSum(null).getNumber();
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum("").getNumber();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나_입력(){
        int result = stringAddCalculator.splitAndSum("1").getNumber();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표구분자(){
        int result = stringAddCalculator.splitAndSum("1,2").getNumber();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 커스텀_콜론구분자(){
        int result = stringAddCalculator.splitAndSum("//;\n1;2").getNumber();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론구분자(){
        int result = stringAddCalculator.splitAndSum("//;\n1;2,3").getNumber();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수_커스텀_구분자(){
        assertThatThrownBy(()->{
            stringAddCalculator.splitAndSum("//;\n-1;2;3");
        }).isInstanceOf(RuntimeException.class);
    }
}
