package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

class WinnersTest {

    @Test
    @DisplayName("레이싱게임의 우승한 Car를 찾는다.")
    void findWinners() {
        Winners winners = new Winners();

        Car avante = new Car("아반떼", 5);
        Car sonata = new Car("소나타", 2);

        List<Car> cars = List.of(avante, sonata);
        Cars racingCars = new Cars(cars);

        assertThat(winners.findWinners(racingCars)).contains(avante);
    }

}
