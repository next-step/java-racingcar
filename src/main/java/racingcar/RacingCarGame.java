package racingcar;

import racingcar.entity.RacingCar;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<RacingCar> racingCars = new ArrayList<>();
        int carNumber = inputView.requestCarNumber();
        int tryNumber = inputView.requestTryNumber();
        initializeRacingCars(racingCars, carNumber, new RandomMoveStrategy());
        race(racingCars, tryNumber);
    }

    public static void initializeRacingCars(List<RacingCar> racingCars, int carNumber, MoveStrategy moveStrategy) {
        for (int i = 0; i < carNumber; i++) {
            racingCars.add(new RacingCar(moveStrategy));
        }
    }

    public static void race(List<RacingCar> racingCars, int tryNumber) {
        resultView.printResultFirstLine();
        for (int i = 0; i < tryNumber; i++) {
            raceOneStep(racingCars);
            resultView.printRacingCarsPosition(racingCars);
        }
    }

    public static void raceOneStep(List<RacingCar> racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).moveIfMovable();
        }
    }
}
