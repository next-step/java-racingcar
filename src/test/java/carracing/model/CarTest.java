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
    @DisplayName("자동차 전진 시 이력 증가")
    void runRace(String carName) {
        Car car = Car.from(carName);
        Long before = car.getSuccessCount();

        car.runRace();
        Long after = car.getSuccessCount();

        assertThat(before).isLessThan(after);
    }

}
