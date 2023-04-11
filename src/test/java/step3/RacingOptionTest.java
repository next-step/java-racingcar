package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingOptionTest {

    @DisplayName("레이싱 게임 조건에 부합하지 않는 인자 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "0,1"})
    void racingOptionThrowExceptionWhenNumberOfCarOrNumberOfRoundIsZero(int numberOfCars, int numberOfRounds) {
        assertThatThrownBy(() -> new RacingOption(numberOfCars, numberOfRounds))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이싱 게임 조건에 부합하는 인자 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "10,10"})
    void racingOptionNotThrowExceptionWhenNumberOfCarAndNumberOfRoundIsNotZero(int numberOfCars, int numberOfRounds) {
        assertThatNoException().isThrownBy(() -> new RacingOption(numberOfCars, numberOfRounds));
    }
}
