package racingcar;

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
        RacingCar[] racingCars = initRacingCars(carCount);
        printResult();

        for (int i = 0; i < tryCount; i++) {
            eachCarAction(carCount, racingCars);
            printCarsPosition(racingCars);
        }
    }

    private static void eachCarAction(int carCount, RacingCar[] racingCars) {
        for (int i = 0; i < carCount; i++){
            racingCars[i].action(roll());
        }
    }


    private static RacingCar[] initRacingCars(int carCount) {
        RacingCar[] racingCars = new RacingCar[carCount];
        for (int i = 0; i < carCount; i++) {
            racingCars[i] = new RacingCar();
        }
        return racingCars;
    }
}