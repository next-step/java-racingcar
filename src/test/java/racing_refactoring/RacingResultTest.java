package racing_refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_refactoring.domain.Car;
import racing_refactoring.domain.RacingResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    private RacingResult racingResult;

    @BeforeEach
    void setRacingCar(){
        List<Car> car = new ArrayList<>();
        car.add(new Car("pobi"));
        car.add(new Car("crong"));

        racingResult = new RacingResult(car);
    }

    @Test
    @DisplayName("경주 후 우승자 확인")
    void findWinners() {
        int maxDistance = racingResult.findMaxDistance();
        assertThat(maxDistance).isEqualTo(0);

        List<Car> winner = racingResult.findWinners();
        assertThat(winner.size()).isEqualTo(2);
    }
}