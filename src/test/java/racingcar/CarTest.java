package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest(name = "랜덤값 0 ~ 9을 받아서 4이상의 값일 때 true, 아닐때 false")
    @ValueSource(ints = {1, 4, 5, 9})
    void isMoveForward_checkMoveForward(int number) {
        Car car = new Car("pobi");
        car.move(number);
        if (number >= 4) {
            assertThat(car.distanceDriven()).isGreaterThan(0);
            return;
        }
        assertThat(car.distanceDriven()).isEqualTo(0);
    }

}
