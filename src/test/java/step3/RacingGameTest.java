package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        racingGame.moveByRepeatCount(new int[] { 9, 3, 9, 7, 5, 5, 7, 0, 0, 2, 7, 5, 7, 6, 6 });
        int[] carPositions = racingGame.getCarPositions();
        assertThat(carPositions.length).isEqualTo(3);
        assertThat(carPositions).containsAnyOf(4, 3, 4);
        System.out.println(Arrays.toString(carPositions));
    }

}
