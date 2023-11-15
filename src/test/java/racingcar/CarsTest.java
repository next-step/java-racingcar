package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarsTest {

    @Test
    @DisplayName("가장 큰 Position을 찾는다.")
    void getMaxPositionTest() {
        Car avante = new Car("아반떼", 5);
        Car sonata = new Car("소나타", 2);

        List<Car> cars = List.of(avante, sonata);
        Cars racingCars = new Cars(cars);

        assertThat(racingCars.getMaxPosition().getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("레이싱게임의 우승한 Car를 찾는다.")
    void findWinners() {
        Car avante = new Car("아반떼", 5);
        Car sonata = new Car("소나타", 2);

        List<Car> cars = List.of(avante, sonata);
        Cars racingCars = new Cars(cars);

        assertThat(racingCars.findWinners()).contains(avante);
    }
}