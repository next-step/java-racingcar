package racingcar.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    @DisplayName("자동차 이름이 주어지면 자동차 객체를 생성한다.")
    void testCreateCars() {
        String[] carNames = {"pobi", "crong", "honux"};
        List<Car> cars = CarFactory.createCars(carNames);

        assertThat(cars.size()).isEqualTo(carNames.length);

        for (int i = 0; i < carNames.length; i++) {
            assertThat(carNames[i]).isEqualTo(cars.get(i).getName());
        }
    }
}
