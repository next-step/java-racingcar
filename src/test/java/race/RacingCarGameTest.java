package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.RacingCar;
import race.domain.RacingCarGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {


    @Test
    @DisplayName("모두 이동하지 않는 경우 공동 우승자가 된다.")
    public void pickRaceWinner() {
        List<String> carNames = List.of("test1", "test2");
        RacingCarGame racingCarGame = new RacingCarGame(carNames, 2);

        List<RacingCar> winners = racingCarGame.findWinners();

        assertThat(winners.size()).isEqualTo(2);

    }
    @Test
    @DisplayName("특정 차량이 앞서있는 경우 해당 차량이 우승자가 된다.")
    public void pickRaceWinner1() {
        RacingCar racingCar1 = new RacingCar("test1");
        RacingCar racingCar2 = new RacingCar("test2");

        racingCar1.moveForward(4);
        racingCar1.moveForward(4);

        RacingCarGame racingCarGame = new RacingCarGame(List.of(racingCar1, racingCar2));

        List<RacingCar> winners = racingCarGame.findWinners();

        assertThat(winners.size()).isEqualTo(1);
    }
}
