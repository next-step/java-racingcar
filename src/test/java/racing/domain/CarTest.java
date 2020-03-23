package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("random 값이 4 이상이면 앞으로 한 칸 전잔한다.")
    public void moveForwardTest() {
        car.moveForward(3);

        assertThat(car.getPosition()).isEqualTo(0);

        car.moveForward(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진을 위한 random 값이 0 <= rand <= 9 이 아니면 IllegalArgumentException 이 발생한다.")
    public void moveForwardExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> car.moveForward(-1));
    }

    @Test
    @DisplayName("position 값이 똑같다면, 같은 선상에서 달리고 있는것 이다.")
    public void isSamePositionTest() {
        Car otherCar = new Car("otherCar");
        otherCar.moveForward(4);
        car.moveForward(4);

        assertThat(car.isSamePosition(otherCar)).isTrue();

        car.moveForward(4);
        assertThat(car.isSamePosition(otherCar)).isFalse();
    }

    @Test
    @DisplayName("이름이 같은 자동차는 같은 자동차로 한다")
    public void equalTest() {
        Car car1 = new Car("test");
        Car car2 = new Car("test");
        assertThat(car1).isEqualTo(car2);
    }

}