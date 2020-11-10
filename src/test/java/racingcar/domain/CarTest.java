package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.number.MovableNumberGenerator;
import racingcar.application.number.NotMovableNumberGenerator;
import racingcar.application.number.NumberGenerator;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final String NAME_OF_CAR = "test";

    @Test
    @DisplayName("주어진 숫자가 4이상이면, 자동차의 이동거리를 1증가시킨다")
    public void should_move_car_by_1() {
        //Given
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        Car car = new Car(NAME_OF_CAR, 0);

        //When
        car.move(numberGenerator);

        //Then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 숫자가 4미만이면, 자동차의 이동거리는 증가하지 않는다.")
    public void should_not_move_car() {
        //Given
        NumberGenerator numberGenerator = new NotMovableNumberGenerator();
        Car car = new Car(NAME_OF_CAR, 0);

        //When
        car.move(numberGenerator);

        //Then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}