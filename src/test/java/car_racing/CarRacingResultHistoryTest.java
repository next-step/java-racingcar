package car_racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingResultHistoryTest {

    @Test
    void createCarRacingResult_default() {
        // given
        CarRacingResultHistory carRacingResultHistory = new CarRacingResultHistory();

        // when
        List<List<CarRacingResult>> result = carRacingResultHistory.getRacingResults();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void update() {
        // given
        CarRacingResult racingResult1 = new CarRacingResult("name1", 1);
        CarRacingResult racingResult2 = new CarRacingResult("name2", 2);
        CarRacingResult racingResult3 = new CarRacingResult("name3", 3);
        CarRacingResult racingResult4 = new CarRacingResult("name4", 4);
        CarRacingResult racingResult5 = new CarRacingResult("name5", 5);
        CarRacingResult racingResult6 = new CarRacingResult("name6", 6);


        List<Car> carList = new ArrayList<Car>() {{
            add(new Car(1, new Name("name1")));
            add(new Car(2, new Name("name2")));
            add(new Car(3, new Name("name3")));
            add(new Car(4, new Name("name4")));
            add(new Car(5, new Name("name5")));
            add(new Car(6, new Name("name6")));
        }};

        Cars cars = new Cars(carList);
        CarRacingResultHistory carRacingResultHistory = new CarRacingResultHistory();

        // when
        carRacingResultHistory.update(cars);
        List<List<CarRacingResult>> result = carRacingResultHistory.getRacingResults();

        // then
        assertThat(result.get(0)).isEqualTo(Lists.newArrayList(
                racingResult1,
                racingResult2,
                racingResult3,
                racingResult4,
                racingResult5,
                racingResult6
        ));
    }

    @Test
    @DisplayName("update winners when number Of winners is 1")
    void updateWinners() {
        // given
        Cars cars = new Cars(Lists.newArrayList(
                new Car(0, new Name("aa")),
                new Car(1, new Name("bb")),
                new Car(2, new Name("cc")),
                new Car(3, new Name("dd")),
                new Car(4, new Name("ee"))
                )
        );
        CarRacingResultHistory resultHistory = new CarRacingResultHistory();

        List<Car> expectedWinnerList = Lists.newArrayList(new Car(4, new Name("ee")));
        Cars expectedWinners = new Cars(expectedWinnerList);

        // when
        resultHistory.updateWinners(cars);
        Cars winners = resultHistory.getWinners();

        // then
        assertThat(winners).isEqualTo(expectedWinners);
    }

    @Test
    @DisplayName("update winners when number Of winners is over 1")
    void updateWinners_manyWinners() {
        // given
        Cars cars = new Cars(Lists.newArrayList(
                new Car(4, new Name("aa")),
                new Car(4, new Name("bb")),
                new Car(2, new Name("cc")),
                new Car(3, new Name("dd")),
                new Car(4, new Name("ee"))
        )
        );
        CarRacingResultHistory resultHistory = new CarRacingResultHistory();
        List<Car> expectedWinnerList = Lists.newArrayList(
                new Car(4, new Name("aa")),
                new Car(4, new Name("bb")),
                new Car(4, new Name("ee"))
        );
        Cars expectWinners = new Cars(expectedWinnerList);

        // when
        resultHistory.updateWinners(cars);
        Cars winners = resultHistory.getWinners();

        // then
        assertThat(winners).isEqualTo(expectWinners);
    }
}