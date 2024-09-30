package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSumCalculatorTest {

    @Test
    void 음수(){
        assertThatThrownBy(()-> StringSumCalculator.sum("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀_구분자(){
        int result = StringSumCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 콜론_쉼표_구분자(){
        int result = StringSumCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 콜론_구분자(){
        int result = StringSumCalculator.sum("1:2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 쉼표_구분자(){
        int result = StringSumCalculator.sum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void null_또는_빈문자열() {
        int result = StringSumCalculator.sum("");
        assertThat(result).isEqualTo(0);

        result = StringSumCalculator.sum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        int result = StringSumCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }
}
