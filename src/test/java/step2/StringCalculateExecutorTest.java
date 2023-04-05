package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.common.exception.CommonExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;

class StringCalculateExecutorTest {

    private StringCalculateExecutor stringCalculateExecutor;

    @BeforeEach
    public void injectInstance() {

        stringCalculateExecutor = StringCalculateExecutor.getInstance();
    }

    @Test
    @DisplayName("빈 문자열 값을 입력 할 경우 0을 반환한다")
    void emptyStringWillReturnZero() {
        // given
        String input = "";

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null 값을 입력 할 경우 0을 반환한다")
    void nullWillReturnZero() {
        // given
        String input = null;

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 입력한 숫자를 반환한다")
    void oneNumberStringWillReturnInputNumber() {
        // given
        String input = "1";

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void twoNumberStringWithCommaWillReturnThatSumEachInputString() {
        // given
        String input = "1,2";

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를  콜론(:) 구분자를 입력할 경우 두 숫자의 합을 반환한다")
    void twoNumberStringWithColonWillReturnThatSumEachInputString() {
        // given
        String input = "1:2";

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("n개의 숫자에 쉼표(,) 와 콜론(:) 구분자를 입력할 경우 숫자의 합을 반환한다.")
    void numberStringWithCommaAndColonWillReturnThatSumEachInputString() {
        // given
        String input = "1,2:3,4";

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("// 와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void customDelimiterWillReturnThatSumEachInputString() {
        // given
        String input = "//;\n1;2;3";

        // when
        int result = stringCalculateExecutor.execute(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 IllegalArgumentException 예외를 던진다")
    void nonNumericOrNegativeNumericWillThrowIllegalArgumentException() {
        // given
        String negativeNumeric = "-1,-2,3,4,5,6,7,8,9,10,11";
        String nonNumeric = "1,2,3*,as";

        IllegalArgumentException negativeNumericIllegalArgumentException = catchIllegalArgumentException(() -> stringCalculateExecutor.execute(negativeNumeric));
        IllegalArgumentException nonNumericIllegalArgumentException = catchIllegalArgumentException(() -> stringCalculateExecutor.execute(nonNumeric));

        // when & then
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(negativeNumericIllegalArgumentException).hasMessageContaining(CommonExceptionMessage.EXIST_NEGATIVE_NUMBER.getUserGuideMessage()),
                () -> assertThat(nonNumericIllegalArgumentException).hasMessageContaining(CommonExceptionMessage.EXIST_NON_NUMERIC.getUserGuideMessage())
        );
    }

}