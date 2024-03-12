package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.mock.AlwaysMoveStrategy;
import racingcar.domain.Distance;
import racingcar.mock.AlwaysStopStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("[성공] 자동차가 전진하면 전진 거리가 증가한다.")
    void 자동차_전진() {
        // Given
        Car car = new Car(null);

        // When
        car.move(new AlwaysMoveStrategy());

        // Then
        assertThat(car.getDistance()).isEqualTo(new Distance(1));
    }

    @Test
    @DisplayName("[성공] 자동차가 전진하지 않으면 전진 거리가 변하지 않는다.")
    void 자동차_정지() {
        // Given
        Car car = new Car(null);

        // When
        car.move(new AlwaysStopStrategy());

        // Then
        assertThat(car.getDistance()).isEqualTo(new Distance(0));
    }


    @Test
    @DisplayName("[성공] 자동차가 5번 전진하면 자동차의 위치가 5로 변경된다.")
    void 자동차_5회_전진() {
        // Given
        Car car = new Car(null);

        // When
        int count = 5;
        while (count-- > 0) {
            car.move(new AlwaysMoveStrategy());
        }

        // Then
        assertThat(car.getDistance()).isEqualTo(new Distance(5));
    }

}
