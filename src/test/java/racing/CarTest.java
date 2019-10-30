package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("move로 이동, getCarPosition으로 검증")
    @Test
    void moveAndGetCarPositionTest() {
        Car car = new Car("testCar");
        car.move();
        int position1 = car.getPosition(0);
        assertThat(position1).isBetween(0, 1);

        car.move();
        int position2 = car.getPosition(1);
        assertThat(position2).isBetween(position1, position1 + 1);

        car.move();
        int position3 = car.getPosition(2);
        assertThat(position3).isBetween(position2, position2 + 1);

    }

}