package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("자동차 수 입력 값만큼 자동차를 생성한다")
    void shouldCreateCars() {
        int numberOfCars = 3;
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        assertThat(cars.size()).isEqualTo(3);
    }
}