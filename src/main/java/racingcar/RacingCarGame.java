package racingcar;

import car.Car;
import car.CarCreator;
import moverule.RandomMoveRule;
import view.InputView;

import java.util.*;

public class RacingCarGame {

    public void start(RandomMoveRule moveRule) {
        int carCount = InputView.getIntValue("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.getIntValue("시도할 회수는 몇 회 인가요?");
        List<Car> carList = CarCreator.create(carCount);
        for(int count = 0; count < tryCount; count++){
            GameRound.play(carList, moveRule);
        }
    }
}
