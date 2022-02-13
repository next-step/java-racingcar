package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 모든_자동차는_횟수에_따라_움직임이_결정된다() {
        RacingGame racingGame = new RacingGame(
            new RacingCars(Arrays.asList(new RacingCar("yang", 3), new RacingCar("woo", 5))), 5);
        List<RacingCars> racingCarsList = racingGame.moveForwardAll(() -> true);
        assertThat(racingCarsList.get(racingCarsList.size() - 1).getRacingCars().get(0).getPosition()).isEqualTo(8);
        assertThat(racingCarsList.get(racingCarsList.size() - 1).getRacingCars().get(1).getPosition()).isEqualTo(10);
    }

    @Test
    void 모든_자동차는_횟수에_따라_정지가_결정된다() {
        RacingGame racingGame = new RacingGame(
            new RacingCars(Arrays.asList(new RacingCar("yang", 3), new RacingCar("woo", 5))), 5);
        List<RacingCars> racingCarsList = racingGame.moveForwardAll(() -> false);
        assertThat(racingCarsList.get(racingCarsList.size() - 1).getRacingCars().get(0).getPosition()).isEqualTo(3);
        assertThat(racingCarsList.get(racingCarsList.size() - 1).getRacingCars().get(1).getPosition()).isEqualTo(5);
    }
}
