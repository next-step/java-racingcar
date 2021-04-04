package car.view;

import car.domain.RacingCar;
import car.domain.RacingCars;

public class ResultView {
    private static final String MOVE_CHAR = "-";

    public static void printStatus(RacingCars racingCars) {
        racingCars.getRacingCars()
                .forEach(it ->
                        System.out.println(
                                it.getCarName() +
                                        " : " +
                                        repeatCharacter(
                                                it.getMoveCount()
                                        )
                        )
                );
        System.out.println();
    }

    public static void printWinner(RacingCars racingCars) {
        String[] winners = getWinners(racingCars);
        System.out.println(
                String.join(",", winners) +
                        "가 최종 우승했습니다."
                );
    }

    private static String[] getWinners(RacingCars racingCars) {
        int maxMoveCount = racingCars
                .getRacingCars()
                .stream()
                .mapToInt(RacingCar::getMoveCount)
                .max()
                .orElse(-1);
        return racingCars
                .getRacingCars()
                .stream()
                .filter(it -> it.getMoveCount() == maxMoveCount)
                .map(RacingCar::getCarName)
                .toArray(String[]::new);
    }

    private static String repeatCharacter(int moveCount) {
        return new String(new char[moveCount])
                .replace("\0", MOVE_CHAR);
    }
}
