package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import car.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,9})
    @DisplayName("경계, 양 끝단 테스트 : 만약 movable 숫자가 4이상 이면, 자동차는 간다.")
    void 자동자_4이상_일때_움직_가능(int carSpeed) {
        final int CAR_MOVE = 1;
        Car car = new Car("hello");

        car.move(carSpeed);

        assertThat(car).extracting("position").isEqualTo(CAR_MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})
    @DisplayName("경계, 양 끝단 테스트 : 만약 movable 숫자가 3이하 이면, 자동차는 못 간다.")
    void 자동자_3이하_일때_움직_가능(int carSpeed) {
        final int CAR_STOP = 0;
        Car car = new Car("hello");

        car.move(carSpeed);

        assertThat(car).extracting("position").isEqualTo(CAR_STOP);
    }
}
