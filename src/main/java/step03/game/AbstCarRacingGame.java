package step03.game;

import step03.calculatescore.ScoreCalculate;
import step03.car.Car;

import java.util.List;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:22 오후
 */
public abstract class AbstCarRacingGame {

    public List<Car> racing(int tryNum, final List<Car> cars, final ScoreCalculate scoreCalculate) {
        while (tryNum-- > 0) {
            gameStart(cars, scoreCalculate);
        }

        return cars;
    }

    abstract public void gameStart(final List<Car> cars, final ScoreCalculate scoreCalculate);
}
