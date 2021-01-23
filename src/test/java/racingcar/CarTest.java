package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Move 테스트")
    public void moveTest() {
        Car testCar = new Car("test");
        testCar.move(5);
        testCar.move(1);
        assertThat(testCar.getPosition()).isEqualTo(1);
    }

}