package racing_winner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    private RacingResult racingResult;

    @BeforeEach
    void setRacingCar(){
        List<Car> car = new ArrayList<>();
        car.add(new Car("pobi",2));
        car.add(new Car("crong",3));
        car.add(new Car("honux",3));

        racingResult = new RacingResult(car);
    }

    @Test
    @DisplayName("경기 후 우승자 찾기 테스트")
    void findWinners() {
        List<Car> winner = racingResult.findWinners();
        assertThat(winner.size()).isEqualTo(2);
    }
}