package racingcar;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;
import racingcar.strategy.NeverMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarManagerTest {

    @Test
    @Description("자동차 수가 양수인 경우 자동차 객체 배열을 반환")
    void prepareCar_Positive() {
        List<Car> result = CarManager.prepareCar(3);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @Description("자동차 수가 음수인 경우 RuntimeException 발생")
    void prepareCar_Negative() {
        assertThatThrownBy(() -> {
            CarManager.prepareCar(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @Description("초기 상태에 자동차가 움직일 수 있는 경우 위치는 1이 된다.")
    void moveCar_True() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(0));
        cars.add(new Car(0));

        CarManager.moveCars(cars, new AlwaysMoveStrategy());
        for (Car car : cars) {
            assertThat(car.getCarLocation()).isEqualTo(1);
        }
    }

    @Test
    @Description("초기 상태에 자동차가 움직일 수 없는 경우 위치는 0이 된다.")
    void moveCar_False() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(0));
        cars.add(new Car(0));

        CarManager.moveCars(cars, new NeverMoveStrategy());
        for (Car car : cars) {
            assertThat(car.getCarLocation()).isEqualTo(0);
        }
    }
}
