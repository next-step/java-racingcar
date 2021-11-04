package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class PreconditionsTest {

    @Test
    @DisplayName("값이 정상적인 경우")
    void checkNotNull() {
        // given
        String param1 = "test data";

        // when & then
        Preconditions.checkNotNull(param1, "param1은 필수값입니다.");
    }

    @Test
    @DisplayName("값이 null 인 경우 예외가 발생 검증")
    void checkNullPointerException() {
        // given
        String param1 = null;

        // when & then
        assertThatNullPointerException().isThrownBy(() -> Preconditions.checkNotNull(param1, "param1은 필수값입니다."));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 10|     0",
            "  1|     0"
    }, delimiter = '|')
    @DisplayName("값이 정상적인 경우")
    void checkNumber(int request, int limit) {
        // when & then
        Preconditions.checkNumber(request, limit, String.format("limit(%d) 값보다 큰 값을 입력해 주세요.", limit));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 0|     0",
            "-1|     0"
    }, delimiter = '|')
    @DisplayName("값이 limit 값이랑 같거나 적은 경우 예외 발생 검증")
    void checkNumberIllegalArgumentException(int request, int limit) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Preconditions.checkNumber(request, limit,
                                                            String.format("limit(%d) 값보다 큰 값을 입력해 주세요.", limit)));
    }
}
