package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    public void 차_이름부여() {
        String carName = "seoyeong";
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    public void 차_생성시_초기값_0() {
        Car car = new Car("test");
        int position = car.getPosition();
        assertThat(car).isNotNull();
        assertThat(position).isEqualTo(0);
    }

    @Test
    public void 값_4미만_이동안하기() {
        Car car = new Car("test");
        int position = car.getPosition();
        car.go(3);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    public void 값_4이상_이동하기() {
        Car car = new Car("test");
        int position = car.getPosition();
        car.go(4);
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }
}