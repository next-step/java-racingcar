package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryRoundTest {
    @DisplayName("총 시도 횟수 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 9, 4})
    void 시도횟수_정상(int param) {
        assertThat(new TryRound(param).equals(new TryRound(param))).isTrue();
    }

    @DisplayName("총 시도 횟수 비정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {0, -1})
    void 시도횟수_비정상(int param) {
        assertThatThrownBy(() -> {
            assertThat(new TryRound(param));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차기 시도 횟수 가능 여부 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {5, 7})
    void 차기_시도_횟수_가능(int param) {
        TryRound tryRound = new TryRound(param);
        tryRound.nextRound();
        assertThat(tryRound.moreRound()).isTrue();
    }

    @DisplayName("차기 시도 횟수 실패 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 2})
    void 차기_시도_횟수_실패(int param) {
        TryRound tryRound = new TryRound(param);
        tryRound.nextRound();
        tryRound.nextRound();
        assertThat(tryRound.moreRound()).isFalse();
    }
}
