package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    @Test
    @DisplayName("이름들을 받아서 해당 이름을 가진 Car 객체들을 생성")
    public void createByNames() {
        String[] names = {"a", "b", "c"};
        Cars cars = new Cars(names);

        for (Car car : cars) {
            assertThat(car.getName()).isIn(names);
        }
    }
}