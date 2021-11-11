package carracing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import carracing.exception.ArgumentOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"donghyo", "dongki"})
    @DisplayName("자동차 이름 길이 초과 예외처리")
    void carNameOutOfRangeException(String carName) {
        assertThatExceptionOfType(ArgumentOutOfRangeException.class)
            .isThrownBy(() -> Car.from(carName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"dong", "hyo"})
    @DisplayName("자동차 정상 생성 및 이름 확인")
    void createCarAndNameCheck(String carName) {
        assertThat(Car.from(carName).getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dong", "hyo"})
    @DisplayName("자동차 전진 성공에 따른 successCount 확인")
    void runRaceTrue(String carName) {
        Car car = Car.from(carName);

        car.runRace(() -> true);
        Long runSuccessCount = car.getSuccessCount();

        assertThat(runSuccessCount).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dong", "hyo"})
    @DisplayName("자동차 전진 실패에 따른 successCount 확인")
    void runRaceFalse(String carName) {
        Car car = Car.from(carName);

        car.runRace(() -> false);
        Long runSuccessCount = car.getSuccessCount();

        assertThat(runSuccessCount).isEqualTo(0);
    }

}
