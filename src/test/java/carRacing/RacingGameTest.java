package carRacing;

import carRacing.model.RacingCar;
import carRacing.model.WinnersName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("자동차 경주 승자 찾기(1명)")
    void racing_game_single_winner() {
        RacingCar racingCar1 = new RacingCar("minn", 1);
        RacingCar racingCar2 = new RacingCar("ssoo", 7);
        RacingCar racingCar3 = new RacingCar("lalze", 4);

        List<RacingCar> racingCarList = Arrays.asList(racingCar1,racingCar2,racingCar3);

        WinnersName name = new WinnersName();

        assertThat(name.findWinner(racingCarList)).isEqualTo(List.of("ssoo"));
    }

    @Test
    @DisplayName("자동차 경주 승자 찾기(여러명)")
    void racing_game_multi_winner() {
        RacingCar racingCar1 = new RacingCar("minn", 7);
        RacingCar racingCar2 = new RacingCar("ssoo", 7);
        RacingCar racingCar3 = new RacingCar("lalze", 3);

        List<RacingCar> racingCarList = Arrays.asList(racingCar1,racingCar2,racingCar3);

        WinnersName name = new WinnersName();

        assertThat(name.findWinner(racingCarList)).isEqualTo(List.of("minn","ssoo"));
    }

}
