import error.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AddCalculatorTest {

    private AddCalculator StringAddCalculator;

    @BeforeEach
    void getCalculator() {
        StringAddCalculator = new AddCalculator();
    }

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//:\n1;2;3//;\n1:2!3//!\n4!4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> SplitAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.ERR_NUMBER_RANGE_MESSAGE.print());
    }

    @Test
    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하면, RuntimeException 예외를 반환한다.")
    void splitAndSum_String() {
        assertThatThrownBy(() -> SplitAddCalculator.calculate("k,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.ERR_NUMBER_FORMAT_MESSAGE.print());
    }
}
