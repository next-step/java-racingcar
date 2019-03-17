package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


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
        assertThat(car).isNotNull();
        assertTrue(car.comparePosition(0) == 0);
    }

    @Test
    public void 값_4미만_이동안하기() {
        Car car = new Car("test",5);
        car.go(3);
        assertTrue(car.comparePosition(5) == 0);
    }

    @Test
    public void 값_4이상_이동하기() {
        Car car = new Car("test",0);
        car.go(4);
        assertTrue(car.comparePosition(1) == 0);
    }

    @Test
    public void 위치_초기화() {
        int value =5;
        assertThat(new Car("sy", value).getPosition()).isEqualTo(value);
    }
}