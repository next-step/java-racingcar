package step4_winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차의 기본 거리는 1이고, move에 4이상의 값이 주어지면 distance가 증가한다")
    void CarMoveTest() {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(1);
        //움직이지 않음
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(1);
        //무조건 움직임
        car.move(4);
        assertThat(car.getDistance()).isGreaterThan(1);
    }

}