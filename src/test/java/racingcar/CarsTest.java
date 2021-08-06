package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Names;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    @Test
    @DisplayName("이름들을 받아서 해당 이름을 가진 Car 객체들을 생성")
    public void createByNames() {
        Names names = new Names(Arrays.asList("a", "b", "c"));
        Cars cars = new Cars(names);

        for (Car car : cars) {
            assertThat(car.getName()).isIn(names);
        }
    }
}