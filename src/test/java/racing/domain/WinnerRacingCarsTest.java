package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("레이싱 게임 우승자들 객체 관련 테스트")
class WinnerRacingCarsTest {

    @DisplayName("자동차 경주 후 단독 우승자를 뽑는다.")
    @Test
    void solo_winner() {

        final List<RacingCar> racingCarList = List.of(new RacingCar(new CarName("pobi"), 3)
                , new RacingCar(new CarName("line"), 2)
                , new RacingCar(new CarName("downbit"), 1)
                , new RacingCar(new CarName("goguma"), 3)
                , new RacingCar(new CarName("bithumt"), 2)
                , new RacingCar(new CarName("codeleesh"), 4)
        );
        final RacingCars racingCars = new RacingCars(racingCarList);
        final WinnerRacingCars winnerRacingCars = new WinnerRacingCars(racingCars.score());
        winnerRacingCars.win();
        final String 우승자 = winnerRacingCars.getWinners().get(0).getName().getCarName();

        assertThat(우승자).isEqualTo("codeleesh");
    }

    @DisplayName("자동차 경주 후 공동 우승자를 뽑는다.")
    @Test
    void co_winner() {

        final List<RacingCar> racingCarList = List.of(new RacingCar(new CarName("pobi"), 4)
                , new RacingCar(new CarName("line"), 2)
                , new RacingCar(new CarName("downbit"), 1)
                , new RacingCar(new CarName("goguma"), 3)
                , new RacingCar(new CarName("bithumt"), 2)
                , new RacingCar(new CarName("codeleesh"), 4)
        );
        final RacingCars racingCars = new RacingCars(racingCarList);
        final WinnerRacingCars winnerRacingCars = new WinnerRacingCars(racingCars.score());
        winnerRacingCars.win();

        assertAll(
                () -> assertThat(winnerRacingCars.getWinners()).hasSize(2),
                () -> assertThat(winnerRacingCars.pick()).isEqualTo("pobi,codeleesh")
        );
    }
}