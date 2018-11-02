package racinggame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class RacingGameTest {

    @Test
    public void 레이싱_이동_확인(){
        RacingGame racingGame = new RacingGame(3, 5){
            @Override
            protected boolean isPossibleMove() {
                return true;
            }
        };
        racingGame.move();

        int[] cars = racingGame.getCars();
        for(int i =0; i < cars.length; i++){
            assertThat(cars[i]).isEqualTo(1);
        }
    }

    @Test
    public void 레이싱_이동_정지(){
        RacingGame racingGame = new RacingGame(3, 5){
            @Override
            public boolean isPossibleMove() {
                return false;
            }
        };
        racingGame.move();

        int[] cars = racingGame.getCars();
        for(int i =0; i < cars.length; i++){
            assertThat(cars[i]).isEqualTo(0);
        }
    }

    @Test
    public void 레이싱_게임진행여부(){
        RacingGame racingGame = new RacingGame(3, 1);
        boolean successGame = racingGame.nextRacingGame();
        assertThat(successGame).isTrue();
        racingGame.move();
        boolean failGame = racingGame.nextRacingGame();
        assertThat(failGame).isFalse();
    }

}