package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차의 최초 전진 상태는 0 이다.")
    @Test
    public void test_1() {
        assertThat(new Car()).isEqualTo(new Car(0));
    }

    @DisplayName("자동차에 4 이상의 값 명령을 내리면 자동차는 전진한다. : 4 명령 시 전진한다. (경계값)")
    @Test
    public void test_2() {
        Car car = new Car();
        car.tryMove(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차에 4 미만의 값 명령을 내리면 자동차는 멈춘다. : 3 명령 시 멈춘다. (경계값)")
    @Test
    public void test_3() {
        Car car = new Car();
        car.tryMove(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 현재 전진 상태를 int 값으로 알 수 있다. (현재 전진 상태가 5라면 5)")
    @Test
    public void test_4() {
        assertThat(new Car(5).getPosition()).isEqualTo(5);
    }
}
