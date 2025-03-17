package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsGeneratorTest {
    @Test
    @DisplayName("쉼표로 구분한 자동차 이름으로 자동차를 생성한다")
    void generateCars() {
        String carNames = "pobi,crong,honux";
        List<Car> cars = new CarsGenerator().generateCars(carNames);
        Assertions.assertThat(cars.size()).isEqualTo(3);
        Assertions.assertThat(cars.stream().map(Car::getName)).containsAll(List.of("pobi", "crong", "honux"));
    }
}
