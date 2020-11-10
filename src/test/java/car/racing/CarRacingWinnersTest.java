package car.racing;

import car.racing.domain.Car;
import car.racing.domain.CarRacingWinners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingWinnersTest {

    @DisplayName("자동차 경주자 우승자들 이름")
    @Test
    void verifyRacingWinners() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 2),
                new Car("crong", 1),
                new Car("honux", 2));
        CarRacingWinners racingWinners = new CarRacingWinners(cars);

        List<String> winners = racingWinners.racingWinners();

        assertThat(winners).containsExactly("pobi", "honux");
    }
}
