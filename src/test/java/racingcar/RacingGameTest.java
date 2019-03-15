package racingcar;

import org.junit.Test;
import racingcar.rulemanager.ImMovableGetRandomNum;
import racingcar.rulemanager.MovableGetRandomNum;
import racingcar.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    String carNames = "가가, 나나,  다다";
    int moveCount = 3;

    @Test
    public void 자동차대수_셋업() {
        RacingGame racingGame = new RacingGame(carNames, moveCount){};
        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }


    @Test
    public void 움직임이_가능한_랜던값_일때_모든_자동차들이_이동한다() {
        RacingGame racingGame = new RacingGame(carNames, new MovableGetRandomNum());
        racingGame.startRace();
        racingGame.startRace();
        racingGame.startRace();
        assertThat(racingGame.getCars().size()).isEqualTo(3);
        assertThat(racingGame.getCars().get(0).getMovingDistance()).isEqualTo(3);
        assertThat(racingGame.getCars().get(1).getMovingDistance()).isEqualTo(3);
        assertThat(racingGame.getCars().get(2).getMovingDistance()).isEqualTo(3);
    }


    @Test
    public void 움직임이_불가능한_랜던값_일때_모든_자동차들이_이동하지않는다() {
        RacingGame racingGame = new RacingGame(carNames, new ImMovableGetRandomNum());
        racingGame.startRace();
        racingGame.startRace();
        racingGame.startRace();
        assertThat(racingGame.getCars().size()).isEqualTo(3);
        assertThat(racingGame.getCars().get(0).getMovingDistance()).isEqualTo(0);
        assertThat(racingGame.getCars().get(1).getMovingDistance()).isEqualTo(0);
        assertThat(racingGame.getCars().get(2).getMovingDistance()).isEqualTo(0);
    }



}