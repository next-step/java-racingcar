package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("우승자 이름을 반환한다")
    @Test
    void winningResult() {
        Car winningCar = new Car("test2", 5);
        List<Car> cars = Arrays.asList(winningCar,
                                        new Car("test", 1),
                                        new Car("test3", 3));

        List<String> winningNames = WinningResult.ofWinningCars(createMockCars(cars));

        assertThat(winningNames).containsExactly(winningCar.getName());
    }

    private Cars createMockCars(List<Car> cars) {
        return new Cars(cars, new MovingGenerator());
    }
}