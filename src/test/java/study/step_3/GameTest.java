package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("자동차 수 입력 값만큼 자동차를 생성한다")
    void shouldCreateCars() {
        int numberOfCars = 3;
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("시도할 횟수 입력 값만큼 게임을 수행한다")
    void shouldTryAsMuchAsInput() {
        Car car = new Car();
        List<Boolean> movable = Arrays.asList(true, false, false, true, true);
        int numberOfTrial = 5;

        for (int i = 0; i < numberOfTrial; i++) {
            car.move(movable.get(i));
        }

        assertThat(car.count()).isEqualTo(3);
    }
}