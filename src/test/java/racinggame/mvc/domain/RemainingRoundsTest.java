package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RemainingRoundsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("시도 횟수가 1보다 작으면 생성할 수 없다.")
    void 유효하지_않은_시도_횟수(int rounds) {
        assertThatThrownBy(() -> new RemainingRounds(rounds))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 라운드를 차감하면 남은 라운드가 없다.")
    void 남은_라운드_확인() {
        RemainingRounds sut = new RemainingRounds(2);

        assertThat(sut.isExhausted()).isFalse();

        sut.decrease();
        assertThat(sut.isExhausted()).isFalse();

        sut.decrease();
        assertThat(sut.isExhausted()).isTrue();
    }

    @Test
    @DisplayName("남은 라운드가 없으면 추가로 진행하거나 차감할 수 없다.")
    void 남은_라운드가_없으면_진행할_수_없다() {
        RemainingRounds sut = new RemainingRounds(1);
        assertThatCode(sut::ensureAvailable).doesNotThrowAnyException();

        sut.decrease();

        assertThatThrownBy(sut::ensureAvailable).isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(sut::decrease).isInstanceOf(IllegalStateException.class);
        assertThat(sut.isExhausted()).isTrue();
    }
}
