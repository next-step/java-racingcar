package racingcar;

import car.Car;
import moverule.RandomMoveRule;

import java.util.List;

public class GameRound {
    public static void play(List<Car> carList, RandomMoveRule moveRule) {
        for(Car car : carList) {
           moveRule.move(car);
        }
    }
}
