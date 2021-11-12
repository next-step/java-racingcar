package utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.RacingConstant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


/**
 * @author han
 */
class StringHelperTest {

    @Test
    @DisplayName("특정 길이 이상의 문자를 입력하면 에러를 던진다")
    void throwExceptionNullOrLengthGreaterThan() {
        assertThatThrownBy(() -> StringHelper.throwExceptionNullOrLengthGreaterThan("Greater than 5", RacingConstant.LIMIT_LENGTH_OF_NAME))
            .isInstanceOf(IllegalArgumentException.class);
    }
}