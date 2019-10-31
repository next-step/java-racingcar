package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("move로 이동, getCarPosition으로 검증")
    @Test
    void moveAndGetCarPositionTest() {
        Car car = new Car("testCar");

        car.move(0);
        assertThat(car.getPosition(0)).isEqualTo(0);

        car.move(1);
        assertThat(car.getPosition(1)).isEqualTo(0);

        car.move(2);
        assertThat(car.getPosition(2)).isEqualTo(0);

        car.move(3);
        assertThat(car.getPosition(3)).isEqualTo(0);

        car.move(4);
        assertThat(car.getPosition(4)).isEqualTo(1);
    }



}