package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class RacingGameTest {

    private RacingGame game;

    private final int cars = 3;
    private final int times = 2;

    @Before
    public void setup() {
        game = new RacingGame(times, cars);
    }

    @Test
    public void 레이싱_정상동작_확인() {
        for (int i = 0; i < times; i++) {
            game.move();
        }

        assertThat(game.isFinish()).isTrue();
        assertThat(game.getCarsPositions().length).isEqualTo(cars);
    }

    @Test
    public void 레이싱_이동_조건_만족시_확인() {
        int moveCondtion = 4;

        setTestMoveGenerator(moveCondtion);

        game.move();

        assertCarMove(1);
    }

    @Test
    public void 레이싱_이동_조건_불만족시_확인() {
        int moveCondtion = 3;

        setTestMoveGenerator(moveCondtion);

        game.move();

        assertCarMove(0);
    }

    private void assertCarMove(int i) {
        for (int position : game.getCarsPositions()) {
            assertThat(position).isEqualTo(i);
        }
    }

    private void setTestMoveGenerator(int moveCondtion) {
        game.setMoveNumberGenerator(new RandomMoveGenerator() {
            @Override
            public int generate() {
                return moveCondtion;
            }
        });
    }

}