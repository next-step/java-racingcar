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
        Car car = new Car();
        car.move(() -> 4);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 랜덤값이_4이하일경우_이동하지않는다() {
        Car car = new Car(()->3);
        car.move(() -> 3);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}