package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CarsTest {

    @DisplayName(value = "Cars를 생성할 수 있다")
    @Test
    void create() {
        new Cars(Arrays.asList(new Car(), new Car()));
    }
}
