package car.view;

import car.RacingCar;

import java.util.List;

public class ResultView {

    public static void printStatus(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
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
