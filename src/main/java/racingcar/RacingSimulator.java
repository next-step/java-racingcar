package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Dice.roll;
import static racingcar.InputView.readCarCount;
import static racingcar.InputView.readTryCount;
import static racingcar.ResultView.printCarsPosition;
import static racingcar.ResultView.printResult;

public class RacingSimulator {


    public static void main(String[] args) {


        int carCount = readCarCount();
        int tryCount = readTryCount();

        simulate(carCount, tryCount);

    }

    private static void simulate(int carCount, int tryCount) {
        List<RacingCar> racingCars = initRacingCars(carCount);
        printResult();

        for (int i = 0; i < tryCount; i++) {
            eachCarAction(racingCars);
            printCarsPosition(racingCars);
        }
    }

    private static void eachCarAction(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> racingCar.action(roll()));
    }


    private static List<RacingCar> initRacingCars(int carCount) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }
}