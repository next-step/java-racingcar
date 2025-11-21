package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("CarName 들을 받아 Cars 객체가 생성된다")
    @Test
    void createCarsWithCarNames() {
        List<CarName> names = new ArrayList<>(List.of(new CarName("carA0"), new CarName("carB")));
        Cars cars = new Cars(names);
        assertThat(cars).isNotNull();
    }
}