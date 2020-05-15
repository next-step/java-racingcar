package study.nextstep.stage3;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    public void stdRacingGameTest(){
        RacingGame game = new RacingGame();
        game.game();
    }

    @Test
    public void racingGameTestWithKeepRun(){
        RacingGame game = new RacingGame(3, 5).setRandomModule(new Random(){
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        });
        game.game();
        for( int i = 0 ; i < game.gameStatus.size() ; i ++ ) {
            assertThat(game.gameStatus.renderCarPostion(i)).isEqualTo(5);
        }
    }

    @Test
    public void racingGameTestWithFirstCarStopSecondCarRun() {
        RacingGame game = new RacingGame(2, 4).setRandomModule(new Random(){
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
        assertThat(game.gameStatus.renderCarPostion(0)).isEqualTo(1);
        assertThat(game.gameStatus.renderCarPostion(1)).isEqualTo(2);
    }
}
