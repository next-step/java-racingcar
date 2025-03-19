package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    public void 자동차의_시작위치는_1이다() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 랜덤값이_4이상일경우_이동한다() {
        int randomValue = 4;
        Car car = new Car(() -> randomValue >= Car.DEFAULT_MOVE_POWER_CONDITION);
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 랜덤값이_4이하일경우_이동하지않는다() {
        int randomValue = 3;
        Car car = new Car(() -> randomValue >= Car.DEFAULT_MOVE_POWER_CONDITION);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}