package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.TestRacingCarConfig.basicMovingStrategy;
import static racingcar.TestRacingCarConfig.moveForwardNumberGenerator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    private static CarMovement carMovement;

    @BeforeAll
    static void setUp() {
        carMovement = new CarMovement(basicMovingStrategy(), moveForwardNumberGenerator());
    }

    @Test
    @DisplayName("자동차 이름 목록과 레이싱 시도 횟수를 통해 레이스를 생성한다.")
    void new_CarNames_Race() {
        final String[] carNames = {"kyle", "alex", "haley"};
        final int playingCount = 1;

        assertThat(Race.of(carNames, playingCount, carMovement))
                .isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0 이하의 레이싱 시도 횟수를 통해 레이스를 생성하는 경우 예외를 던진다.")
    void new_NegativeOrZeroPlayingCount_Exception(final int negativeOrZeroPlayingCount) {
        final String[] carNames = {"kyle", "alex", "haley"};

        assertThatThrownBy(() -> Race.of(carNames, negativeOrZeroPlayingCount, carMovement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱 시도 횟수는 자연수만 가능합니다.");
    }
}
