package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarGeneratorTest {

    @Test
    @DisplayName("주어진 수 만큼 자동차가 생성되어야 한다.")
    void generateCars() {
        final Integer givenCarCount = 3;
        List<Car> carList = new CarGenerator().generateCar(givenCarCount);
        Assertions.assertThat(carList.size()).isEqualTo(givenCarCount);
    }
}