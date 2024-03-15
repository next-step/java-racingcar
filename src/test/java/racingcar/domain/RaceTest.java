package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    @Test
    @DisplayName("자동차 이름 목록과 레이싱 시도 횟수를 통해 레이스를 생성한다.")
    void new_CarNames_Race() {
        final String[] carNames = {"kyle", "alex", "haley"};
        final int playingCount = 1;

        assertThat(new Race(carNames, playingCount))
                .isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0 이하의 레이싱 시도 횟수를 통해 레이스를 생성하는 경우 예외를 던진다.")
    void new_NegativeOrZeroPlayingCount_Exception(final int negativeOrZeroPlayingCount) {
        final String[] carNames = {"kyle", "alex", "haley"};

        assertThatThrownBy(() -> new Race(carNames, negativeOrZeroPlayingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱 시도 횟수는 자연수만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름 목록에 중복이 존재한 상태로 레이스를 생성하는 경우 예외를 던진다.")
    void new_DuplicatedCarNames_Exception() {
        final String[] duplicatedCarNames = {"kyle", "kyle", "alex"};

        assertThatThrownBy(() -> new Race(duplicatedCarNames, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
