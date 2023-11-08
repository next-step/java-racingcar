package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Dice.roll;
import static racingcar.ResultView.*;
import static racingcar.WinnerFinder.findWinner;

public class RacingSimulator {

    private RacingSimulator() {
    }

    public static void simulate(List<String> carNames, int tryCount) {
        List<RacingCar> racingCars = initRacingCars(carNames);
        printResult();

        for (int i = 0; i < tryCount; i++) {
            eachCarAction(racingCars);
            printCarsPosition(racingCars);
        }

        printWinner(findWinner(racingCars));
    }

    private static void eachCarAction(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> racingCar.action(roll()));
    }


    private static List<RacingCar> initRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new RacingCar(carNames.get(i)));
        }
        return racingCars;
    }
}