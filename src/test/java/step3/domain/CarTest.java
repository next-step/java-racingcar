package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("distance만큼 움직인 위치를 position 리스트에 저장한다.")
    @Test
    void move() {
        Car car = new Car();
        car.move(1);
        assertThat( car.getPosition(0)).isEqualTo(1);

        car.move(1);
        assertThat( car.getPosition(1)).isEqualTo(2);


        car.move(0);
        assertThat( car.getPosition(1)).isEqualTo(2);

    }

}