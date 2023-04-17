package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingOptionTest {

    private static final int MIN_NUMBER = 1;
    private static final String MINIMUM_NAMES = "test";
    private static final String EMPTY_NAMES_1 = ",";
    private static final String EMPTY_NAMES_2 = "  ";

    @DisplayName("레이싱 게임에 필요한 최소 차량 수, 라운드 횟수 테스트")
    @Test
    void racingOptionNotThrowsWhenNumberOfCarAndNumberOfRoundMeetMinimumRequire() {
        UserInput userInput = new UserInput(MINIMUM_NAMES, MIN_NUMBER);
        assertThatNoException().isThrownBy(() -> RacingOption.from(userInput));
    }

    @DisplayName("레이싱 게임에 필요한 최소 차량 수에 미달하는 조건 테스트")
    @ParameterizedTest
    @ValueSource(strings = {EMPTY_NAMES_1, EMPTY_NAMES_2})
    void racingOptionThrowExceptionWhenNumberOfCarLessThanOne(String carNames) {
        UserInput userInput = new UserInput(carNames, MIN_NUMBER);
        assertThatThrownBy(() -> RacingOption.from(userInput));
    }

    @DisplayName("레이싱 게임에 필요한 최소 라운드 수에 미달하는 조건 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-3, 0})
    void racingOptionThrowExceptionWhenNumberOfRoundLessThanOne(int numberOfRounds) {
        UserInput userInput = new UserInput(MINIMUM_NAMES, numberOfRounds);
        assertThatThrownBy(() -> RacingOption.from(userInput));
    }
}
