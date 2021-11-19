package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryRoundTest {
    @DisplayName("시도횟수 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 9, 4})
    void 시도횟수_정상(int param) {
        assertThat(new TryRound(param).getTryRound()).isEqualTo(param);
    }

    @DisplayName("시도횟수 비정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {0, -1})
    void 시도횟수_비정상(int param) {
        assertThatThrownBy(() -> {
            assertThat(new TryRound(param));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
