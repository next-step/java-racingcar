package racingcar.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static final int HISTORY_SIZE = 1;

    @ParameterizedTest
    @DisplayName("자동차 생성 테스트")
    @ValueSource(strings = "hyo")
    void createCar(String name) {
        assertThat(Car.from(name)).isEqualTo(Car.from(name));
    }

    @ParameterizedTest
    @DisplayName("자동차 이동 성공 테스트")
    @CsvSource(value = "kim,1")
    void carMoveTrue(String name, int count) {
        Car car = Car.from(name);
        car.move(() -> true);
        assertThat(car.getHistorySuccessCount(HISTORY_SIZE)).isEqualTo(count);
    }

    @ParameterizedTest
    @DisplayName("자동차 이동 실패 테스트")
    @CsvSource(value = "kim,0")
    void carMoveFalse(String name, int count) {
        Car car = Car.from(name);
        car.move(() -> false);
        assertThat(car.getHistorySuccessCount(HISTORY_SIZE)).isEqualTo(count);
    }

}
