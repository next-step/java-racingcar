package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


class RacingGameTest {

    private RacingGame racingGame;

    @DisplayName("자동차 수 만큼 랜덤숫자를 뽑은 후 전진한다.")
    @Test
    void moveCarPositions() {
        int moveCount = 5;
        int carCount = 3;
        racingGame = new RacingGame(moveCount, carCount);

        //전진하는 경우
        int forward = racingGame.forwardStatus(8);
        assertThat(forward).isEqualTo(1);

        //전진 못하는 경우
        int notForward = racingGame.forwardStatus(0);
        assertThat(notForward).isEqualTo(0);


        racingGame.moveByRepeatCount();
        List<Integer> carPositions = racingGame.getCarPositions();
        assertThat(carPositions).hasSize(3);
        for (Integer carPosition : carPositions) {
            System.out.println(carPosition);
        }
    }

}
