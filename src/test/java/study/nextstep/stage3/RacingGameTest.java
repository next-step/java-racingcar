package study.nextstep.stage3;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RacingGameTest {
    @Test
    public void stdRacingGameTest(){
        RacingGame game = new RacingGame();
        game.game();
    }

    @Test
    public void stdRacingGameTestWithKeepRun(){
        RacingGame game = new RacingGame(3, 5).setRandomModule(new Random(){
            @Override
            public int nextInt(int bound) {
                return 9;
            }
        });
        game.game();
    }
}
