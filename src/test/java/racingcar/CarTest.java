package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {
    Car car = new Car("TestCar");

    @Test
    void 랜덤값_4이상_전진테스트() {
        car.moveOrStop(4);
        car.moveOrStop(4);
        car.moveOrStop(4);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void 랜덤값_4이하_정지테스트() {
        car.moveOrStop(0);
        car.moveOrStop(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
