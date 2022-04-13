package newcarracing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void 자동차_이름_부여해서_경주_준비() {
        String input = "pobi,crong,honux";
        String[] carNames = input.split(",");
        List<RacingCar> racingCars = RacingGame.initRacingCars(carNames);
        assertThat(racingCars).hasSize(3);
        assertThat(racingCars.get(0).getName()).isEqualTo("pobi");
        assertThat(racingCars.get(1).getName()).isEqualTo("crong");
        assertThat(racingCars.get(2).getName()).isEqualTo("honux");
    }

    @Test
    void 자동차_경주_5회_시도_우승자_확인() {
        String input = "pobi,crong,honux,lion,young";
        String[] carNames = input.split(",");
        List<RacingCar> racingCars = RacingGame.initRacingCars(carNames);
        int tryCount = 5;
        for(int i = 1; i <= tryCount; i++) {
            RacingGame.racing(racingCars);
            ResultView.printRacingCarsRoutes(racingCars);
            System.out.println();
        }
        ResultView.printWinners(RacingGame.createWinnersList(racingCars));
    }
}