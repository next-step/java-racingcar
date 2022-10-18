package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("차가 움직이면 위치가 증가한다")
    @Test
    public void move_NumberIsLessThanFour_KeepPosition() {
        Car car = new Car(1);

        // When
        car.move(new NumberGenerator() {
            @Override
            public int generate() {
                return 5;
            }
        });

        // Then
        assertThat(car).extracting("position").isEqualTo(2);
    }

}