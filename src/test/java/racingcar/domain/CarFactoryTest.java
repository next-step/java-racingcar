package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private static final List<CarName> CAR_NAMES =
            List.of(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
    private static final Position DEFAULT_POSITION = new Position(0);

    @DisplayName("이름 리스트와 같은 순서로 위치가 0인 차 리스트 생성")
    @Test
    void generateCars() {

        List<Car> cars = CarFactory.generateCars(CAR_NAMES);

        assertThat(cars.size()).isEqualTo(CAR_NAMES.size());
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i))
                    .isEqualTo(new Car(CAR_NAMES.get(i), DEFAULT_POSITION));
        }
    }
}