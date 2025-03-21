package step4.racingcar2.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameRoundTest {

    @Test
    @DisplayName("라운드 우승자를 찾기")
    void givenRacingCars_whenGameRound_thenFindWinners() {
        // given
        RacingCar car1 = new RacingCar(new RacingCarName("car1"), new RacingCarEngine(), 3);
        RacingCar car2 = new RacingCar(new RacingCarName("car2"), new RacingCarEngine(), 1);
        RacingCar car3 = new RacingCar(new RacingCarName("car3"), new RacingCarEngine(), 2);
        RacingCar car4 = new RacingCar(new RacingCarName("car4"), new RacingCarEngine(), 4);
        RacingCar car5 = new RacingCar(new RacingCarName("car5"), new RacingCarEngine(), 4);
        List<RacingCar> cars = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5));
        RacingCarGameRound gameRound = new RacingCarGameRound(cars);

        // when
        List<RacingCar> winners = gameRound.winners();

        // then
        assertThat(winners).containsExactly(car4, car5);
    }

}
