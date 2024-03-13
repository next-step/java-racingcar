package racingCar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingRefereeTest {

    RacingCar pobi;
    RacingCar crong;
    RacingCar honux;

    @BeforeEach
    void init() {
        pobi = new RacingCar(new CarName("pobi"));
        crong = new RacingCar(new CarName("crong"));
        honux = new RacingCar(new CarName("honux"));
    }

    @Test
    @DisplayName("우승자가 한명일 때")
    void One_Winner_Test() {
        pobi.move(true);
        crong.move(false);
        honux.move(false);
        RacingCars cars = new RacingCars(List.of(pobi, crong, honux));

        List<String> winners = RacingReferee.pickWinners(cars);
        Assertions.assertThat(winners).containsExactly(pobi.findCarName().findName());
    }

    @Test
    @DisplayName("우승자가 두명일 때")
    void Two_Winner_Test() {
        pobi.move(true);
        crong.move(true);
        honux.move(false);
        RacingCars cars = new RacingCars(List.of(pobi, crong, honux));

        List<String> winners = RacingReferee.pickWinners(cars);
        Assertions.assertThat(winners).containsExactly(
            pobi.findCarName().findName(), crong.findCarName().findName());
    }

    @Test
    @DisplayName("우승자가 세명일 때")
    void Three_Winner_Test() {
        pobi.move(true);
        crong.move(true);
        honux.move(true);
        RacingCars cars = new RacingCars(List.of(pobi, crong, honux));

        List<String> winners = RacingReferee.pickWinners(cars);
        Assertions.assertThat(winners)
            .containsExactly(
                pobi.findCarName().findName(),
                crong.findCarName().findName(),
                honux.findCarName().findName());
    }

}

