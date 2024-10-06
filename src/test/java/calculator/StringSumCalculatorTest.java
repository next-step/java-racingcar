package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSumCalculatorTest {

    @Test
    @DisplayName("숫자가 아닌 문자가 있을 때 RuntimeException 예외 발생")
    void 숫자가_아닌_문자(){
        assertThatThrownBy(()-> StringSumCalculator.getInstance().sum("1,2,a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수일 때 RuntimeException 예외 발생")
    void 음수(){
        assertThatThrownBy(()-> StringSumCalculator.getInstance().sum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀 구분자 사용했을 때 숫자 전체 합 반환")
    void 커스텀_구분자(){
        int result = StringSumCalculator.getInstance().sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론, 쉼표 구분자 같이 사용")
    void 콜론_쉼표_구분자(){
        int result = StringSumCalculator.getInstance().sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 구분자 사용했을 때 숫자 전체 합 반환")
    void 콜론_구분자(){
        int result = StringSumCalculator.getInstance().sum("1:2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표 구분자를 사용했을 때 숫자 전체 합 반환")
    void 쉼표_구분자(){
        int result = StringSumCalculator.getInstance().sum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("null 또는 빈 문자열이 들어왔을 때, 0 반환")
    void null_또는_빈문자열() {
        int result = StringSumCalculator.getInstance().sum("");
        assertThat(result).isEqualTo(0);

        result = StringSumCalculator.getInstance().sum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 하나일 때 숫자 반환")
    void 숫자_하나() {
        int result = StringSumCalculator.getInstance().sum("1");
        assertThat(result).isEqualTo(1);
    }
}
