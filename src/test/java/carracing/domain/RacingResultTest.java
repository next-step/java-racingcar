package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    @Test
    @DisplayName("우승자는 kim이다")
    void findWinner() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("kim", 3));
        cars.add(new RacingCar("lee", 2));
        cars.add(new RacingCar("park", 1));
        RacingResult result = new RacingResult(cars);
        List<String> carNames = result.findWinners();
        assertThat(carNames.getFirst()).isEqualTo("kim");
    }

    @Test
    @DisplayName("우승자는 여러명일 수 있다")
    void findWinners() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("kim", 3));
        cars.add(new RacingCar("lee", 3));
        cars.add(new RacingCar("park", 1));
        RacingResult result = new RacingResult(cars);
        assertThat(result.findWinners()).hasSize(2);
    }
}