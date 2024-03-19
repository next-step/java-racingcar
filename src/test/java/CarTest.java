import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("입력값이 4 이상이면 전진한다")
    public void carMoveForward() {

        Car car = new Car();
        car.moveForward(5);

        assertThat(car.position()).isEqualTo(1);
    }



    @Test
    @DisplayName("입력값이 4 미만이면 전진 불가능하다")
    public void cannotMoveInputLessThan_4() {

        Car car = new Car();
        car.moveForward(3);

        assertThat(car.position()).isEqualTo(0);
    }


}
