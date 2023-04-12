package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1, 0, 1, 2, 3})
    @DisplayName("자동차는 지정한 만큼 움직인다")
    public void move(int movement) {
        Car car = new Car("test", () -> movement);
        car.move();

        int distance = car.distance();
        assertThat(distance).isEqualTo(movement);
    }

}