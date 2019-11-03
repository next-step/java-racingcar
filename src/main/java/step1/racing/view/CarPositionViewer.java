package step1.racing.view;

import step1.racing.RacingGame;
import step1.racing.data.RacingCar;

public class CarPositionViewer {
    private static final String CAR_INDICATOR = "-";

    public static void printStatus(RacingGame racingGame) {
        for (RacingCar racingCar : racingGame.getRacingCars()) {
            System.out.println(racingCar.getName() + " : " + printConcatenatedChar(CAR_INDICATOR, racingCar.getPosition()));
        }
    }

    public static void printWinner(RacingGame racingGame) {
        racingGame.getWinners().forEach(car -> System.out.println(car.getName()));
    }

    private static String printConcatenatedChar(String flag, int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num ; i ++) {
            sb.append(flag);
        }

        return sb.toString();
    }
}
