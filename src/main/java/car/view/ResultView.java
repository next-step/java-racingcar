package car.view;

import car.domain.RacingCar;
import car.domain.RacingCars;

public class ResultView {

    public static void printStatus(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(
                    racingCar.getCarName()
                    + " : " +
                    repeatCharacter(
                            "-",
                            racingCar.getMoveCount()
                    )
            );
        }
        System.out.println();
    }

    public static void printWinner(RacingCars racingCars) {
        int maxMoveCount = racingCars
                .getRacingCars()
                .stream()
                .mapToInt(RacingCar::getMoveCount)
                .max()
                .orElse(-1);
        String[] winners = racingCars
                .getRacingCars()
                .stream()
                .filter(it -> it.getMoveCount() == maxMoveCount)
                .map(RacingCar::getCarName)
                .toArray(String[]::new);
        System.out.println(
                String.join(",", winners) +
                        "가 최종 우승했습니다."
                );
    }

    private static String repeatCharacter(String character, int moveCount) {
        return new String(new char[moveCount])
                .replace("\0", character);
    }
}
