package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {

    private static final int FINAL_ROUND = 0;

    @DisplayName("Round 생성 시 round 를 해당 값으로 초기화")
    @ParameterizedTest
    @ValueSource(ints = { 1, 10000 })
    void create(final int value) {
        assertThatCode(() -> Round.of(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("Round 생성 실패: round 가 0보다 작거나 같은 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -10000 })
    void failureCreate(final int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> Round.of(value));
    }

    @DisplayName("다음 라운드를 수행하면 round 값이 1 감소한다.")
    @Test
    void nextRound() {
        Round round = Round.of(FINAL_ROUND + 1);
        assertThat(round.nextRound().isEndRound()).isTrue();
    }

    @DisplayName("마지막 라운드면 true 를 반환한다.")
    @Test
    void isEndRound() {
        assertThat(new Round().isEndRound()).isTrue();
    }
}
