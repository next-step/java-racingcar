package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("레이싱 게임 우승자 검증")
    @Test
    void findRacingGameWinner() {
        Car alpha = new Car("ALPHA", 3);
        Car beta = new Car("BETA", 2);
        Car charlie = new Car("CHARLIE", 3);

        Cars cars = new Cars(Arrays.asList(alpha, beta, charlie));
        List<Car> winner = cars.findWinners();

        assertThat(winner).containsExactly(alpha, charlie);
    }
}
