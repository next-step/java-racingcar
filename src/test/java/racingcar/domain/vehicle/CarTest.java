package racingcar.domain.vehicle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.engine.Engine;

@DisplayName("[Step4] 자동차")
class CarTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "pobi,0"}
    )
    public void create(String name, int distance) {
        // given

        // when
        Car car = CarFactory.create(name, distance);

        // then
        assertThat(car.getDistance()).isEqualTo(distance);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("[성공] 주행")
    @ParameterizedTest
    @CsvSource(value = {
        "0,0",
        "1,0",
        "3,0",
        "4,1",
        "9,1"}
    )
    public void drive(int engineResult, int expected) {
        // given
        Engine engine = () -> engineResult;
        Car car = CarFactory.create(engine, "");

        // when
        car.drive();

        // then
        assertThat(car.getDistance()).isEqualTo(expected);
    }
}
