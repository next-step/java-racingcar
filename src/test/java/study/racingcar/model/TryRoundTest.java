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

    @DisplayName("총 시도 횟수 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 3, 5})
    void 총_시도_횟수(int param) {
        assertThat(new TryRound(param).getTryRound()).isEqualTo(param);
    }

    @DisplayName("차기 시도 횟수 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 3, 5})
    void 차기_시도_횟수(int param) {

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
