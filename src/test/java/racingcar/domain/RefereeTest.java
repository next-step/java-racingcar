package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 우승자를_2명_이상을_판별한다() {
        final int DISTANCE = 5;
        final List<String> players = Arrays.asList("dami", "jason");
        Cars cars = new Cars(players);
        List<Car> totalCars = cars.getCars();

        totalCars.forEach(car -> car.move(DISTANCE));

        List<String> winners = Referee.getWinners(cars);

        assertThat(winners).isEqualTo(players);
    }

    @Test
    void 우승자를_1명을_판별한다() {
        final int MIN_DISTANCE = 6;
        final int MAX_DISTANCE = 8;
        final List<String> players = Arrays.asList("jason", "dami");
        final List<String> winner = Arrays.asList("dami");

        Cars cars = new Cars(players);
        List<Car> totalCars = cars.getCars();

        for (int i = 0; i < players.size(); i++) {
            Car car = cars.getCars().get(i);
            if (i == 0) {
                car.move(MIN_DISTANCE);
            }
            if (i == 1) {
                car.move(MAX_DISTANCE);
            }
        }

        List<String> winners = Referee.getWinners(cars);

        assertThat(winners).isEqualTo(winner);
    }
}