package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    static final int MOVEABLE_RANDOMNUM = 4;
    static final int NONE_MOVEABLE_RANDOMNUM = 1;
    private InputReq inputReq;

    @Before
    public void 자동차_3대_초기값() {
        inputReq = new InputReq();
        inputReq.setCarNames("가가, 나나,  다다");
        inputReq.setMoveCount(3);
    }

    @Test
    public void 자동차대수_셋업() {
        RacingGame racingGame = new RacingGame(inputReq);
        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }


    @Test
    public void canMove가_true_일때_모든_자동차들이_이동한다() {
        boolean canMove = true;
        RacingGame race = new RacingGame(inputReq) {
            @Override
            public void run() {
                for (Car car : getCars()) {
                    if (canMove) {
                        car.moveCar(MOVEABLE_RANDOMNUM);
                    }
                }
            }
        };
        race.run();
        race.run();
        race.run();
        assertThat(race.getCars().size()).isEqualTo(3);
        assertThat(race.getCars().get(0).getMovingDistance()).isEqualTo(3);
        assertThat(race.getCars().get(1).getMovingDistance()).isEqualTo(3);
        assertThat(race.getCars().get(2).getMovingDistance()).isEqualTo(3);
    }


    @Test
    public void canMove가_false_일때_모든_자동차들이_이동하지않는다() {

        boolean canMove = false;
        RacingGame race = new RacingGame(inputReq) {
            @Override
            public void run() {
                for (Car car : getCars()) {
                    if (canMove) {
                        car.moveCar(NONE_MOVEABLE_RANDOMNUM);
                    }
                }
            }
        };
        race.run();
        race.run();
        race.run();
        assertThat(race.getCars().size()).isEqualTo(3);
        assertThat(race.getCars().get(0).getMovingDistance()).isEqualTo(0);
        assertThat(race.getCars().get(1).getMovingDistance()).isEqualTo(0);
        assertThat(race.getCars().get(2).getMovingDistance()).isEqualTo(0);
    }



}