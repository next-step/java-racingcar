import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAdditionCalculatorTest {
    @Test
    @DisplayName("쉼표(,) 기준으로 분리한 각 숫자의 합을 반환")
    void commaDelimiterSumTest() {
        //given
        final String input = "1,2";

        //when
        int sum = StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("코론(:) 기준으로 분리한 각 숫자의 합을 반환")
    void colonDelimiterSumTest() {
        //given
        final String input = "1:2";

        //when
        int sum = StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("빈배열일 경우 0 반환")
    void blankInputTest() {
        //given
        final String input = "";

        //when
        int sum = StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("null일 경우 0 반환")
    void nullInputTest() {
        //given
        final String input = null;

        //when
        int sum = StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    void singleInputTest() {
        //given
        final String input = "1";

        //when
        int sum = StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThat(sum).isEqualTo(1);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자")
    void customDelimiterSumTest() {
        //given
        final String input = "//;\n1;2;3";

        //when
        int sum = StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    void negativeInputRuntimeExceptionTest() {
        //given
        final String input = "-1,2,3";

        //when
        ThrowableAssert.ThrowingCallable callable = () -> StringAdditionCalculator.sum(input);

        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(RuntimeException.class);
    }
}
