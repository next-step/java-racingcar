package study.nextstep.stage3;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    public void stdRacingGameTest(){
        RacingGame game = new RacingGame(StandardInputView.create(), new Random());
        game.run();
    }

    @Test
    public void racingGameTestWithKeepRun(){
        RacingGame game = new RacingGame(new InputView() {
            @Override
            public int getCars() {
                return 3;
            }

            @Override
            public int getCount() {
                return 5;
            }
        }, new Random(){
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        });
        game.run();
        for( int i = 0 ; i < game.gameStatus.size() ; i ++ ) {
            assertThat(game.gameStatus.renderCarPosition(i)).isEqualTo(5);
        }
    }

    @Test
    public void racingGameTestWithFirstCarStopSecondCarRun() {
        RacingGame game = new RacingGame(new InputView() {
            @Override
            public int getCars() {
                return 2;
            }

            @Override
            public int getCount() {
                return 4;
            }
        }, new Random(){
            int status = 0;
            @Override
            public int nextInt(int bound) {
                if( status == 0 ){
                    status = 1;
                    return 0;
                }
                status = 0;
                return bound - 1;
            }
        });
        game.gameStatus.turn();
        assertThat(game.gameStatus.renderCarPosition(0)).isEqualTo(1);
        assertThat(game.gameStatus.renderCarPosition(1)).isEqualTo(2);
    }

    @Test
    public void racingGameInvalidTurn() {
        RacingGame game = new RacingGame(new InputView() {
            @Override
            public int getCars() {
                return 0;
            }

            @Override
            public int getCount() {
                return 0;
            }
        }, new Random());
        game.run();
        assertThatIllegalArgumentException().isThrownBy(() -> game.gameStatus.renderCarPosition(0));
    }
}
