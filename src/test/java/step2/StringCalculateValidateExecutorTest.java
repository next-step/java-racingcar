package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.common.exception.CommonExceptionMessage;
import step2.model.Input;
import step2.validator.NegativeNumericValidator;
import step2.validator.NonNumericValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;

class StringCalculateValidateExecutorTest {

    private final StringCalculateSeparator stringCalculateSeparator = new StringCalculateSeparator();

    @Test
    @DisplayName("숫자 이외의 값 전달할 경우 IllegalArgumentException 예외를 던진다")
    void nonNumericWillThrowIllegalArgumentException() {
        // given
        Input input = stringCalculateSeparator.executeSeparator("1,2,3*,as");
        IllegalArgumentException nonNumericIllegalArgumentException = catchIllegalArgumentException(() -> getNonNumericValidatorInstance().executeValidator(input));

        // when & then
        assertThat(nonNumericIllegalArgumentException).hasMessageContaining(CommonExceptionMessage.EXIST_NON_NUMERIC.getUserGuideMessage());
    }

    @Test
    @DisplayName("음수를 전달할 경우 IllegalArgumentException 예외를 던진다")
    void negativeNumericWillThrowIllegalArgumentException() {
        // given
        Input input = stringCalculateSeparator.executeSeparator("1,2,-3");
        IllegalArgumentException nonNumericIllegalArgumentException = catchIllegalArgumentException(() -> getNegativeNumericValidatorInstance().executeValidator(input));

        // when & then
        assertThat(nonNumericIllegalArgumentException).hasMessageContaining(CommonExceptionMessage.EXIST_NEGATIVE_NUMBER.getUserGuideMessage());
    }

    private StringCalculateValidateExecutor getNonNumericValidatorInstance() {

        return new StringCalculateValidateExecutor(new NonNumericValidator());
    }

    private StringCalculateValidateExecutor getNegativeNumericValidatorInstance() {

        return new StringCalculateValidateExecutor(new NegativeNumericValidator());
    }
}