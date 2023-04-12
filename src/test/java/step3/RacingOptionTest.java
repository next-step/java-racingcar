package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingOptionTest {

    private static final int MIN_NUMBER = 1;

    @DisplayName("레이싱 게임에 필요한 최소 차량 수, 라운드 횟수 테스트")
    @Test
    void racingOptionNotThrowsWhenNumberOfCarAndNumberOfRoundMeetMinimumRequire() {
        assertThatNoException().isThrownBy(() -> new RacingOption(MIN_NUMBER, MIN_NUMBER));
    }

    @DisplayName("레이싱 게임에 필요한 최소 차량 수에 미달하는 조건 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-3, 0})
    void racingOptionThrowExceptionWhenNumberOfCarLessThanOne(int numberOfCars) {
        assertThatThrownBy(() -> new RacingOption(numberOfCars, MIN_NUMBER));
    }

    @DisplayName("레이싱 게임에 필요한 최소 라운드 수에 미달하는 조건 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-3, 0})
    void racingOptionThrowExceptionWhenNumberOfRoundLessThanOne(int numberOfRounds) {
        assertThatThrownBy(() -> new RacingOption(MIN_NUMBER, numberOfRounds));
    }
}
