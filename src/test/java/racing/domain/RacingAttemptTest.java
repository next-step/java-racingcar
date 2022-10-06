package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 게임 시도 횟수 객체 관련 테스트")
class RacingAttemptTest {

    @DisplayName("시도 횟수는 0이하인 경우 익셉션 처리한다.")
    @Test
    void race_zero_attempt() {

        assertThatThrownBy(() -> RacingAttempt.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @DisplayName("시도 횟수의 문자가 포함된 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"d1", "te"})
    void race_string_attempt(final String str) {

        assertThatThrownBy(() -> RacingAttempt.from(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }
}
