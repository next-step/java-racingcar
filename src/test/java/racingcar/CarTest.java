package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.vehicle.Car;
import racingcar.vehicle.CarFactory;

@DisplayName("[Step3] 자동차")
class CarTest {

    private final Car car = CarFactory.create();

    @DisplayName("[성공] 주행")
    @ParameterizedTest
    @CsvSource(value = {
        "0,0",
        "1,0",
        "3,0",
        "4,1",
        "9,1"}
    )
    public void drive(int input, int expected) {
        // given

        // when
        car.drive(input);

        // then
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @DisplayName("[실패] 주행 - 입력 범위를 벗어남")
    @ParameterizedTest
    @CsvSource(value = {
        "-1",
        "10"}
    )
    public void drive_outOfRange(int input) {
        // given

        // when
        assertThrows(IllegalArgumentException.class, () -> car.drive(input));

        // then
    }
}
