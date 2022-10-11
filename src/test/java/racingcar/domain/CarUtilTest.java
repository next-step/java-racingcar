package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarUtilTest {

    @Test
    @DisplayName("생성된 각 차의 이름은 파라미터와 동일해야 한다.")
    void initCar() {
        String[] names = {"car1", "car2", "car3"};

        List<Car> cars = CarUtil.initCars(names);

        assertThat(cars).hasSize(3)
                .containsExactly(new Car("car1"), new Car("car2"), new Car("car3"));
    }
}
