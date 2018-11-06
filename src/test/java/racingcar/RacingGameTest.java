package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;
    int[] carPositions = {0, 0, 0};

    @Before
    public void setup() {
        racingGame = new RacingGame();
    }

    @Test
    public void 이동범위체크_0_to_3() {
        carPositions = racingGame.move();
        carPositions = racingGame.move();
        carPositions = racingGame.move();
        assertThat(carPositions[0]).isIn(0, 1, 2, 3);
        assertThat(carPositions[1]).isIn(0, 1, 2, 3);
        assertThat(carPositions[2]).isIn(0, 1, 2, 3);
    }

    @Test
    public void 랜덤값_범위체크_0_to_9() {
        int random = racingGame.getRandom();
        boolean isRange = (random >= 0 && random < 10);
        assertThat(isRange).isTrue();
    }

    @Test
    public void 전진_가능한_조건이라면_한칸_이동() {
        int[] carPositions = {0, 0, 0};
        if(racingGame.isCanMove()) {
            carPositions[0] = carPositions[0] + 1;
        }

        assertThat(carPositions[0]).isIn(0, 1);
    }

    @Test
    public void 한칸_이동_테스트() {
        racingGame.moveOnePosition(0, true);
        int[] carPositions = racingGame.getCarPositions();
        assertThat(carPositions[0]).isEqualTo(1);
    }
}
