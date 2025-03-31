package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.RacingGame;
import racingCar.domain.RoundStatusDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void shouldFindWinners() {
        Car car1 = new Car("Car1", 1);
        Car car2 = new Car("Car2", 2);
        Car car3 = new Car("Car3", 2);

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);

        RacingGame racingGame = new RacingGame(cars, new TestMoveStrategy(true));

        List<RoundStatusDTO> winners = racingGame.findWinners();

        RoundStatusDTO expectedCar2 = new RoundStatusDTO("Car2", 2);
        RoundStatusDTO expectedCar3 = new RoundStatusDTO("Car3", 2);

        assertThat(winners).containsExactly(expectedCar2, expectedCar3);
    }
}
