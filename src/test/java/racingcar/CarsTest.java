package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

class CarsTest {

    @DisplayName(value = "Cars를 생성할 수 있다")
    @Test
    void create() {
        Car pobi = new Car("pobi", 3);
        Car conan = new Car("conan", 2);
        new Cars(Arrays.asList(pobi, conan));
    }
}
