package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.AlwaysMovingStrategy;

class CarTest {

    @Test
    @DisplayName("move 메소드는 MovingStrategy 에서 반환하는 값에 따라 position 값이 변화한다.")
    void move_numberOver4() {
        Car car = new Car("jordy");
        car.move(new AlwaysMovingStrategy());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("isSamePosition 메소드는 주어진 값과 같은 위치 값을 같고 있는지 판단한다.")
    void isSamePosition() {
        Car car = new Car("jordy", 1);

        assertThat(car.isSamePosition(1)).isTrue();
    }
}