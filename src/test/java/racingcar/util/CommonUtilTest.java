package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommonUtilTest {

    @DisplayName("입력되는 문자열이 NULL 일 경우 IllegalArgumentException 이 나는 지 확인 (Default Exception Message)")
    @ParameterizedTest
    @NullAndEmptySource
    public void checkNullEmptyTest(String source) {
        assertThatThrownBy(() -> {
            CommonUtil.checkNullEmpty(source);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Argument is null or empty.");
    }

    @DisplayName("입력되는 문자열이 NULL 일 경우 IllegalArgumentException 이 나는 지 확인 (Custom Exception message)")
    @ParameterizedTest
    @NullAndEmptySource
    public void checkNullEmptyCustomExceptionMessageTest(String source) {
        final String message = "null or empty";
        assertThatThrownBy(() -> {
            CommonUtil.checkNullEmpty(source, message);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @DisplayName("0 미만의 숫자가 입력될 경우 IllegalArgumentException 이 나는 지 확인")
    @Test
    public void checkZeroOrMoreNegativeTest() {
        final int number = -1;
        assertThatThrownBy(() -> {
            CommonUtil.checkZeroOrMore(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}