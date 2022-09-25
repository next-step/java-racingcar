package racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.core.gasstation.GasStation;
import racinggame.core.gasstation.TankGasStation;
import racinggame.core.scoreboard.ScoreBoard;
import racinggame.core.scoreboard.Score;

class RacingGameTest {

    private static final int NUM_OF_GAME = 4;
    private static final String CAR_NAMES = "pobi,crong,honux";

    @Test
    @DisplayName("주어진 게임 정보에 대해 경기 후의 결과 테스트")
    void play_with_game_info() {
        RacingGame game = new RacingGame(initCars(), initGasStation());

        ScoreBoard resultScoreBoard = game.play(NUM_OF_GAME);

        Score scoreOfRound1 = resultScoreBoard.getScore(1);
        Score scoreOfRound2 = resultScoreBoard.getScore(2);
        Score scoreOfRound3 = resultScoreBoard.getScore(3);
        Score scoreOfRound4 = resultScoreBoard.getScore(4);

        assertAll(
                () -> assertThat(scoreOfRound1.getScore("pobi")).isEqualTo(0),
                () -> assertThat(scoreOfRound1.getScore("crong")).isEqualTo(0),
                () -> assertThat(scoreOfRound1.getScore("honux")).isEqualTo(1),
                () -> assertThat(scoreOfRound2.getScore("pobi")).isEqualTo(1),
                () -> assertThat(scoreOfRound2.getScore("crong")).isEqualTo(0),
                () -> assertThat(scoreOfRound2.getScore("honux")).isEqualTo(2),
                () -> assertThat(scoreOfRound3.getScore("pobi")).isEqualTo(2),
                () -> assertThat(scoreOfRound3.getScore("crong")).isEqualTo(0),
                () -> assertThat(scoreOfRound3.getScore("honux")).isEqualTo(3),
                () -> assertThat(scoreOfRound4.getScore("pobi")).isEqualTo(3),
                () -> assertThat(scoreOfRound4.getScore("crong")).isEqualTo(0),
                () -> assertThat(scoreOfRound4.getScore("honux")).isEqualTo(3)
        );

        /*  <result>
            [0, 0, 1]
            [1, 0, 2]
            [2, 0, 3]
            [3, 0, 3]
         */
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        for (String carName : CAR_NAMES.split(",")) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private GasStation initGasStation() {
        Queue<Integer> tank = new LinkedList<>();

        for (int i = 0; i < NUM_OF_GAME * CAR_NAMES.split(",").length; i++) {
            tank.add(i * 3 % 10);
            //연료: 0, 3, 6,  9, 12, 15,  18, 21, 24,  27, 30, 33
        }

        return new TankGasStation(tank);
    }

}
