package racingcar.domain.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    public Cars setUp() {
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(4));
        Car honux = new Car ("honux", new Position(4));
        List<Car> carList = Arrays.asList(pobi, crong, honux);
        Cars newCars = new Cars(carList);
        return newCars;
    }

    @Test
    void getWinnersNamesFromTest() {
        String expectedNames = "crong, honux";

        assertThat(setUp().getWinnersNames()).isEqualTo(expectedNames);
    }

    @Test
    void getCarsRaceHistTest() {

        Set<String> raceHistKeys = setUp().getRaceHist().keySet();
        assertThat(raceHistKeys.toString()).isEqualTo("[pobi, crong, honux]");
        assertThat(setUp().getRaceHist().get("pobi")).isEqualTo(3);
        assertThat(setUp().getRaceHist().get("honux")).isEqualTo(4);
    }
}
