package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차가 움직이면 위치가 증가한다")
    void move() {
        Car car = new Car(0);

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    @Test
    public void move_NumberIsLessThanFour_KeepPosition() {
        Car car = new Car(1);

        // When
        car.move(3);

        // Then
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @DisplayName("숫자가 4보다 크거나 같으면 위치를 1 증가")
    @Test
    public void move_NumberIsEqualOrGreaterThanFour_IncreasePositionByOne() {
        Car car = new Car(1);

        car.move(4);

        assertThat(car).extracting("position").isEqualTo(2);
    }


}