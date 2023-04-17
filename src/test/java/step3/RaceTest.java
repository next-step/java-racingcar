package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Race;
import step3.domain.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    @DisplayName("경주가 끝난 자동차의 위치는 round 수 초과이거나 음수일 수 없다")
    void testCarCanNotMoveBeyondRound() {
        int raceRound = 5;
        Race race = new Race(getMockRacingCars(), raceRound);

        race.start();

        for (Car car : race.getCars()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(raceRound);
            assertThat(car.getPosition()).isNotNegative();
        }
    }

    private RacingCars getMockRacingCars() {
        return new RacingCars(List.of("car1", "car2", "car3"));
    }
}
