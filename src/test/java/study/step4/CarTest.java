package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("차량 등록, 이름, 출발점 확인")
    @ParameterizedTest
    @ValueSource(strings = {"차량1호", "차량2호", "차량3호"})
    void getLocation(String carName) {
        Car car = Car.of(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("차량 이동")
    @ParameterizedTest
    @CsvSource(value = {"차량1호:3:3", "차량2호:4:4", "차량3호:5:5"}, delimiter = ':')
    void move(String carName, int movingCount, int expected) {
        Car car = Car.of(carName);
        while (movingCount-- > 0) {
            car.move();
        }
        assertThat(car.getLocation()).isEqualTo(expected);
    }
}
