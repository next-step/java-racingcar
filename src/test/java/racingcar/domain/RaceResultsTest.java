package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.LapResult;
import racingcar.domain.RaceResults;

public class RaceResultsTest {

    @Test
    void 레이스_최종결과() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("1"), new Car("2"), new Car("3")));
        List<LapResult> lapResults = new ArrayList<>();
        lapResults.add(new LapResult(cars));

        cars = new ArrayList<>(Arrays.asList(new Car("1"), new Car("2"), new Car("3")));
        cars.get(0).move();
        lapResults.add(new LapResult(cars));

        List<Car> result = new RaceResults(lapResults).finalResult().cars();
        assertAll(
            () -> assertThat(result.get(0).position()).isEqualTo(Car.SET_POSITION + 1),
            () -> assertThat(result.get(1).position()).isEqualTo(Car.SET_POSITION),
            () -> assertThat(result.get(2).position()).isEqualTo(Car.SET_POSITION)
        );
    }

}
