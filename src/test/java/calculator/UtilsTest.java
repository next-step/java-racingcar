package calculator;

import calculator.util.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class UtilsTest {

    @DisplayName("null 또는 empty string 전달시 에러")
    @NullAndEmptySource
    @ParameterizedTest
    public void nullOrEmpty(String str) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Utils.checkNullOrEmpty(str));
    }

    @DisplayName("숫자가 아닌 문자열 변환시 에러")
    @NullAndEmptySource
    @ParameterizedTest
    public void stringToLong(String str) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Utils.stringToLong(str));
    }


}
