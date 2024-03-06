package CarRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("자동차는 값이 4 이상일 때 이동 가능하다.")
    public void movableIsTrueWhenRandomNumberIsGreaterThanOrEqualFour() throws Exception{
        Car car = new Car();
        assertThat(car.isMovable(4)).isTrue();
    }

    @Test
    @DisplayName("자동차는 값이 3 이하일 때 이동 불가능하다.")
    public void movableIsFalseWhenRandomNumberIsLessThanFour() throws Exception{
        Car car = new Car();
        assertThat(car.isMovable(3)).isFalse();
    }

    @Test
    @DisplayName("자동차는 값이 4 이상일 때, 위치를 1 이동한다.")
    public void randomNumberIsGreaterThanOrEqualFourThenUpdateCarPosition() throws Exception{
        Car car = new Car();
        car.updatePosition(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 값이 3 이하일 때, 움직이지 않는다.")
    public void randomNumberIsLessThanFourThenNotUpdateCarPosition() throws Exception{
        Car car = new Car();
        car.updatePosition(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
