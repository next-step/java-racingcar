package racinggame;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class RacingGameTest {

    String [] carName;

    @Before
    public void 레이싱_카셋팅(){
        carName = "pobi,crong,honux".split(",");
    }

    @Test
    public void 레이싱_이동_확인(){
        RacingGame racingGame = new RacingGame(carName, 5){
            @Override
            protected boolean isPossibleMove() {
                return true;
            }
        };
        racingGame.move();

        List<Car> cars = racingGame.getCars();
        for(int i =0; i < cars.size(); i++){
            assertThat(cars.get(i).getLocation()).isEqualTo(1);
        }
    }

    @Test
    public void 레이싱_이동_정지(){
        RacingGame racingGame = new RacingGame(carName, 5){
            @Override
            public boolean isPossibleMove() {
                return false;
            }
        };
        racingGame.move();

        racingGame.move();

        List<Car> cars = racingGame.getCars();
        for(int i =0; i < cars.size(); i++){
            assertThat(cars.get(i).getLocation()).isEqualTo(0);
        }
    }

    @Test
    public void 레이싱_게임진행여부(){
        RacingGame racingGame = new RacingGame(carName, 1);
        boolean successGame = racingGame.nextRacingGame();
        assertThat(successGame).isTrue();
        racingGame.move();
        boolean failGame = racingGame.nextRacingGame();
        assertThat(failGame).isFalse();
    }

}