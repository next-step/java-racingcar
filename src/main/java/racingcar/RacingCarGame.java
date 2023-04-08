package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfTries = InputView.getNumberOfTries();
        List<RacingCar> racingCars = new ArrayList<>();
        setUpCars(numberOfCars, racingCars);

        System.out.println("실행 결과");

        for (int i = 0; i < numberOfTries; i++) {
            tryOnce(numberOfCars, racingCars);
        }
    }

    private static void tryOnce(int numberOfCars, List<RacingCar> racingCars) {
        for (int j = 0; j < numberOfCars; j++) {
            racingCars.get(j).goOrStop(NumberRange.getOne());
            OutputView.printPosition(racingCars.get(j));
        }
        System.out.println();
    }

    private static void setUpCars(int numberOfCars, List<RacingCar> racingCars) {
        for (int i = 0; i < numberOfCars; i++) {
            racingCars.add(new RacingCar());
        }
    }
}
