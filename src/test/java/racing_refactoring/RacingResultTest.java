package racing_refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_refactoring.domain.Car;
import racing_refactoring.domain.RacingResult;
import racing_refactoring.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    private RacingResult racingResult;

    @BeforeEach
    void setRacingCar(){
        List<Car> car = new ArrayList<>();
        car.add(new Car("pobi", 1));
        car.add(new Car("crong", 0));

        racingResult = new RacingResult(car);
    }

    @Test
    @DisplayName("경주 후 우승자 확인")
    void findWinners() {List<Car> winner = racingResult.findWinners();
        assertThat(winner.size()).isEqualTo(1);
    }
}