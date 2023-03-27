package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;

import java.util.List;

import static racingcar.view.InputView.*;
import static racingcar.view.ResultView.*;

public class RacingMain {
    public static void main(String[] args) {
        List<Car> cars = inputCars();
        int gameCnt = inputGameCnt();
        RacingCar racingCar = new RacingCar(cars, gameCnt);
        printRace(cars, racingCar.getGameWinner());
    }
}
