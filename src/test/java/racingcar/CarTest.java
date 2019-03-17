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
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 위치_초기화() {
        int value =5;
        assertThat(new Car("sy", value).getPosition()).isEqualTo(value);
    }

    @Test
    public void 전진하기() {
        Car car = new Car("test",5);
        car.go(true);
        assertThat(car.getPosition()).isEqualTo(6);
    }

    @Test
    public void 정지하기() {
        Car car = new Car("test",5);
        car.go(false);
        assertThat(car.getPosition()).isEqualTo(5);
    }
}