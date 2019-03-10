package racing;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

    @Test
    public void 랜덤함수() {
        //given
        int expected = 3;
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return expected;
            }
        };

        //when
        int actual = random.nextInt(9);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 한칸이동() {
        //given
        int position = 3;
        RacingGame game = new RacingGame(new int[]{0, 0, 0}) {
            @Override
            public boolean canMove() {
                return true;
            }
        };

        //when
        int actual = game.move(position);

        //then
        assertThat(actual).isEqualTo(position + 1);
    }

    @Test
    public void 모두한칸이동() {
        //given
        RacingGame game = new RacingGame(new int[]{0, 0, 0}) {
            @Override
            public boolean canMove() {
                return true;
            }
        };

        //when
        int[] actual = game.move();

        //then
        assertThat(actual).isEqualTo(new int[]{1, 1, 1});
    }

    @Test
    public void 게임한번실행() {
        //given
        RacingGame game = new RacingGame(new int[]{0, 0, 0}, 1) {
            @Override
            public boolean canMove() {
                return true;
            }
        };

        //when
        int[] actual = game.start();

        //then
        assertThat(actual).isEqualTo(new int[]{1, 1, 1});
    }

    @Test
    public void 게임여러번실행() {
        //given
        RacingGame game = new RacingGame(new int[]{0, 0, 0}, 3) {
            @Override
            public boolean canMove() {
                return true;
            }
        };

        //when
        int[] actual = game.start();

        //then
        assertThat(actual).isEqualTo(new int[]{3, 3, 3});
    }
}