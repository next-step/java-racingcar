package step3.racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racinggame.core.gasstation.GasStation;
import step3.racinggame.core.gasstation.TankGasStation;

class RacingGameTest {

    private static final int NUM_OF_GAME = 3;
    private static final int NUM_OF_CAR = 4;

    @Test
    @DisplayName("주어진 게임 정보에 대해 경기 후의 결과 테스트")
    void play_with_game_info() {
        RacingGame game = new RacingGame(initCars(), initGasStation());

        ScoreBoard resultScoreBoard = game.play(NUM_OF_GAME);

        assertAll(
                () -> assertThat(resultScoreBoard.getDistance(1, 1)).isEqualTo(0),
                () -> assertThat(resultScoreBoard.getDistance(1, 2)).isEqualTo(0),
                () -> assertThat(resultScoreBoard.getDistance(1, 3)).isEqualTo(1),
                () -> assertThat(resultScoreBoard.getDistance(1, 4)).isEqualTo(1),
                () -> assertThat(resultScoreBoard.getDistance(2, 1)).isEqualTo(0),
                () -> assertThat(resultScoreBoard.getDistance(2, 2)).isEqualTo(1),
                () -> assertThat(resultScoreBoard.getDistance(2, 3)).isEqualTo(2),
                () -> assertThat(resultScoreBoard.getDistance(2, 4)).isEqualTo(1),
                () -> assertThat(resultScoreBoard.getDistance(3, 1)).isEqualTo(1),
                () -> assertThat(resultScoreBoard.getDistance(3, 2)).isEqualTo(2),
                () -> assertThat(resultScoreBoard.getDistance(3, 3)).isEqualTo(2),
                () -> assertThat(resultScoreBoard.getDistance(3, 4)).isEqualTo(1)
        );

        /*  <result>
            [0, 0, 1, 1]
            [0, 1, 2, 1]
            [1, 2, 2, 1]
         */
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < NUM_OF_CAR; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private GasStation initGasStation() {
        Queue<Integer> tank = new LinkedList<>();

        for (int i = 0; i < NUM_OF_GAME * NUM_OF_CAR; i++) {
            tank.add(i * 3 % 10);
            //연료: 0, 3, 6, 9,  12, 15, 18, 21,  24, 27, 30, 33
        }

        return new TankGasStation(tank);
    }

}
