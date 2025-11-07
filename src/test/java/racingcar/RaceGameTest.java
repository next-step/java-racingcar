package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceGameTest {

    @DisplayName("자동차가 여러 대 생성된다")
    @Test
    void createCars() {
        int count = 3;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        assertThat(cars).hasSize(count);
    }
}
