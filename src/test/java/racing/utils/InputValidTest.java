package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidTest {

    @DisplayName("이름이 null이거나 공백일때 에러발생")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmptyWithNull(String input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValid.isEmpty(input));

    }

    @DisplayName("반복횟수가 -거나, 0일때")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void timeGreaterThenZeroWithError(int input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValid.timeGreaterThenZero(input));

    }

    @DisplayName("반복횟수가 0이상일때")
    @Test
    void timeGreaterThenZeroWithSuccess() {
        InputValid.timeGreaterThenZero(2);
    }


}