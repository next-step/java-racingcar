package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {


    @DisplayName("자동차 경주를 진행한다.")
    @Test
    void runRacingGame(){
        RacingGame racingGame = new RacingGame(1);
    }

    @DisplayName("n대의 자동차를 생성한다.")
    @Test
    void createRacingCar(){
        RacingGame racingGame = new RacingGame(4);
        assertThat(racingGame.getCarSize()).isEqualTo(4);
    }


    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void canMoveRacingCar(){
        int numberOfCar = 1;
        RacingGame racingGame = new RacingGame(1);
        racingGame.tryMove(5);
        throw new RuntimeException("검증 추가");
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @Test
    void moveIfNumberIsMoreThan4(){
        RacingGame racingGame = new RacingGame(1);
        racingGame.tryMove(4);

        throw new RuntimeException("검증 추가");
    }



}
