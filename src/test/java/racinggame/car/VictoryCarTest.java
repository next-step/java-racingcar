package racinggame.car;

import org.junit.Before;
import org.junit.Test;
import racinggame.car.Car;
import racinggame.game.RacingGame;
import racinggame.rule.RandomNumberRacing;

import java.util.List;

import static org.junit.Assert.*;

public class VictoryCarTest {

    String[] carName;

    @Before
    public void 레이싱_카셋팅(){
        carName = new String[]{"pobi","crong", "honux"};
    }

    @Test
    public void 레이싱_순위_1등(){
        RacingGame racingGame = new RacingGame(carName, 2, new RandomNumberRacing());

        List<Car> cars = racingGame.getCar();
        cars.get(0).move(() -> true);

        assertEquals(racingGame.getVictorCar().size(), 1);
    }

    @Test
    public void 레이싱_순위_공동1등(){
        RacingGame racingGame = new RacingGame(carName, 2, new RandomNumberRacing());

        List<Car> cars = racingGame.getCar();
        cars.get(0).move(() -> true);
        cars.get(1).move(() -> true);

        assertEquals(racingGame.getVictorCar().size(), 2);
    }


}