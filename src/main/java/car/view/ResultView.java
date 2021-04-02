package car.view;

import car.domain.RacingCar;
import car.domain.RacingCars;

import java.util.List;

public class ResultView {

    public static void printStatus(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(
                    repeatCharacter(
                            "-",
                            racingCar.getMoveCount()
                    )
            );
        }
        System.out.println();
    }

    private static String repeatCharacter(String character, int moveCount) {
        return new String(new char[moveCount])
                .replace("\0", character);
    }
}
