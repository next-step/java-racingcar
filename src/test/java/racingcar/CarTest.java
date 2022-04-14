package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차의 속도가 4이상이면 이동거리가 1씩 증가한다.")
    void game() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Assertions.assertThat(car1.getDistance()).isEqualTo(0);
        Assertions.assertThat(car1.getDistance()).isEqualTo(0);
        Assertions.assertThat(car1.getDistance()).isEqualTo(0);

        car1.setSpeed(4);
        car2.setSpeed(3);
        car3.setSpeed(5);

        car1.move();
        car2.move();
        car3.move();

        Assertions.assertThat(car1.getDistance()).isEqualTo(1);
        Assertions.assertThat(car2.getDistance()).isEqualTo(0);
        Assertions.assertThat(car3.getDistance()).isEqualTo(1);

        car1.setSpeed(8);
        car2.setSpeed(9);
        car3.setSpeed(1);

        car1.move();
        car2.move();
        car3.move();

        Assertions.assertThat(car1.getDistance()).isEqualTo(2);
        Assertions.assertThat(car2.getDistance()).isEqualTo(1);
        Assertions.assertThat(car3.getDistance()).isEqualTo(1);
    }
}
