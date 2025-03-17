package car_racing.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceResultsTest {

    @Test
    @DisplayName("더 많이 움직인 차가 우승한다")
    void getWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        car1.move(2);
        car2.move(1);

        RaceResults raceResults = new RaceResults(List.of(car1, car2));
        assertThat(raceResults.getWinners()).isEqualTo(List.of(car1));
    }
}
