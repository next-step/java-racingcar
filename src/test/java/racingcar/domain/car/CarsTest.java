package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void findWinnersTest() {
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(4));
        Car honux = new Car ("honux", new Position(4));
        List<Car> carList = Arrays.asList(pobi, crong, honux);
        Cars newCars = new Cars(carList);
        assertThat(newCars.filterWinners()).hasSize(2);
        assertThat(newCars.filterWinners()).containsExactly(crong, honux);
    }

    @Test
    void getWinnersNamesFromTest() {
        Car pobi = new Car("pobi", new Position(2));
        Car crong = new Car("crong", new Position(1));
        Car honux = new Car ("honux", new Position(2));
        List<Car> carList = Arrays.asList(pobi, crong, honux);
        Cars newCars = new Cars(carList);

        assertThat(newCars.getWinnersNames()).isEqualTo("pobi, honux");
    }

    @Test
    void getCarsRaceHistTest() {
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(3));
        Car honux = new Car ("honux", new Position(2));
        List<Car> carList = Arrays.asList(pobi, crong, honux);
        Cars newCars = new Cars(carList);

        Set<String> raceHistKeys = newCars.getRaceHist().keySet();
        assertThat(raceHistKeys.toString()).isEqualTo("[pobi, crong, honux]");
        assertThat(newCars.getRaceHist().get("pobi")).isEqualTo(3);
        assertThat(newCars.getRaceHist().get("honux")).isEqualTo(2);
    }
}
