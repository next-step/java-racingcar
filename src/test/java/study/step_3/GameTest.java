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
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("시도할 횟수 입력 값만큼 게임을 수행한다")
    void shouldTryAsMuchAsInput() {
        int numberOfTrial = 5;
        List<Boolean> randomNumbers = Arrays.asList(true, false, false, true, true);
        Car car = new Car();

        for (int i = 0; i < numberOfTrial; i++) {
            car.move(randomNumbers.get(i));
        }

        assertThat(car.count()).isEqualTo(3);
    }
}