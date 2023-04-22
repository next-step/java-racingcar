package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("경주가 끝난 자동차의 위치는 round 수 초과일 수 없다")
    void testCarCanNotMoveBeyondRound() {
        RaceRound raceRound = RaceRound.of(5);
        Race race = new Race(getMockRacingCars(), raceRound, ()->true);

        race.start();

        for (Car car : race.getCars()) {
            assertThat(car.getPositionValue()).isLessThanOrEqualTo(raceRound.getValue());
        }
    }

    @Test
    @DisplayName("경주가 끝난 자동차의 위치는 음수일 수 없다")
    void testFinishPositionCannotBeNegative() {
        RaceRound raceRound = RaceRound.of(5);
        Race race = new Race(getMockRacingCars(), raceRound, ()->false);

        race.start();

        for (Car car : race.getCars()) {
            assertThat(car.getPositionValue()).isNotNegative();
        }
    }

    private RacingCars getMockRacingCars() {
        return RacingCars.create(List.of("car1", "car2", "car3"));
    }
}
