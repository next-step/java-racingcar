package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.module.RacingGame;
import racingcar.module.RacingRound;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("게임 횟수 만큼 게임이 진행되는지 비교")
    @Test
    void startGame() {
        //GIVE
        RacingGame game = new RacingGame();
        Cars cars = new Cars(3);

        //WHEN
        RacingRound result = game.startGame(cars, 3);
        //THEN
        assertThat(result.getRoundResult().get(0)).isNotNull();
    }




}
