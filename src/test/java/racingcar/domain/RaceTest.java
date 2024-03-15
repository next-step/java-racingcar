package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    @Test
    @DisplayName("양의 정수의 자동차 대수와 레이싱 시도 횟수를 전달하면 정상적으로 Race 객체를 생성한다.")
    void new_PositiveCarCountAndPlayingCount_Race() {
        assertThat(new Race(1, 1))
                .isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("Race 객체 생성 시, 0 혹은 음의 정수의 자동차 대수를 전달하면 예외를 던진다.")
    void new_NegativeOrZeroCarCount_Exception(final int negativeOrZeroCarCount) {
        assertThatThrownBy(() -> new Race(negativeOrZeroCarCount, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 대수는 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("Race 객체 생성 시, 0 혹은 음의 정수의 레이싱 시도 횟수를 전달하면 예외를 던진다.")
    void new_NegativeOrZeroPlayingCount_Exception(final int negativeOrZeroPlayingCount) {
        assertThatThrownBy(() -> new Race(1, negativeOrZeroPlayingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱 시도 횟수는 자연수만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름 목록을 전달하면 정상적으로 Race 객체를 생성한다.")
    void new_CarNames_Race() {
        final String[] carNames = {"kyle", "alex", "haley"};

        assertThat(new Race(carNames, 1))
                .isNotNull();
    }

    @Test
    @DisplayName("Race 객체 생성 시, 중복된 자동차 이름 목록을 전달하면 예외를 던진다.")
    void new_DuplicatedCarNames_Exception() {
        final String[] duplicatedCarNames = {"kyle", "kyle", "alex"};

        assertThatThrownBy(() -> new Race(duplicatedCarNames, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
