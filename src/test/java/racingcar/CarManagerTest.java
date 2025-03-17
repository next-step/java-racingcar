package racingcar;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarManagerTest {

    @Test
    @Description("자동차 수가 양수인 경우 자동차 객체 배열을 반환")
    void prepareCar_Positive() {
        Car[] result = CarManager.prepareCar(3);
        assertThat(result).hasSize(3);
    }

    @Test
    @Description("자동차 수가 음수인 경우 RuntimeException 발생")
    void prepareCar_Negative() {
        assertThatThrownBy(() -> {
            CarManager.prepareCar(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @Description("자동차를 한번 움직인 경우 모든 자동차의 위치가 0 또는 1이어야 함")
    void moveCar_1Try() {
        Car[] cars = new Car[]{new Car(0), new Car(0)};
        CarManager.moveCars(cars);
        for (Car car : cars) {
            assertThat(car.getCarLocation()).isBetween(0, 1);
        }
    }

    @Test
    @Description("자동차를 두번 움직인 경우 모든 자동차의 위치가 0 또는 2이어야 함")
    void moveCar_2Try() {
        Car[] cars = new Car[]{new Car(0), new Car(0), new Car(0)};
        CarManager.moveCars(cars);
        CarManager.moveCars(cars);
        for (Car car : cars) {
            assertThat(car.getCarLocation()).isBetween(0, 2);
        }
    }

    @Test
    @Description("random 값이 4 이상일 경우 움직일 수 있다.")
    void canMove_True() {
        assertThat(CarManager.canMove(4)).isTrue();
    }

    @Test
    @Description("random 값이 4 미만일 경우 움직일 수 없다.")
    void canMove_False() {
        assertThat(CarManager.canMove(3)).isFalse();
    }

}
