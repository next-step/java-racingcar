package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingCarNameOverSizeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @ParameterizedTest(name = "자동차 생성 정상 테스트 - input: {0}")
    @ValueSource(strings = {"w", "wo", "woo", "wood", "woody"})
    void createCarWithName_success(String carNameInput) {
        RacingCar racingCar = new RacingCar(carNameInput);
        assertThat(racingCar.getName()).startsWith("w");
    }

    @ParameterizedTest(name = "자동차 생성 예외 발생 테스트 - input: {0}")
    @ValueSource(strings = {"", "woody.mjin"})
    void createCarWithName_failure(String carNameInput) {
        assertThatThrownBy(() -> new RacingCar(carNameInput)).isInstanceOf(RacingCarNameOverSizeException.class)
                                                             .hasMessageContaining("최대 길이");
    }

    @DisplayName("한 칸 이동 테스트")
    @Test
    void moveRacingCar() {
        RacingCar racingCar = new RacingCar("woody");
        racingCar.move(() -> true);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @DisplayName("제자리 테스트")
    @Test
    void stayRacingCar() {
        RacingCar racingCar = new RacingCar("woody");
        racingCar.move(() -> false);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }
}
