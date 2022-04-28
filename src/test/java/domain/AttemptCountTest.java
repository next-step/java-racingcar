package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptCountTest {
    @DisplayName("경기 시도 횟수 생성 - 정상 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void createAttemptCountTest(String count) {
        assertThat(new AttemptCount(count))
                .isEqualTo(new AttemptCount(Integer.parseInt(count)));
    }

    @DisplayName("경기 시도 횟수 생성 - 실패 케이스")
    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1회"})
    void createAttemptCountTestFail(String count) {
        assertThatThrownBy(() -> new AttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
