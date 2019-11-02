package step1.racing.view;

import step1.racing.RacingCarHandler;
import step1.racing.data.RacingCar;

public class CarPositionViewer {
    public static void printStatus(RacingCarHandler carPositions, String flag) {
        for (RacingCar racingCar : carPositions.getRacingCars()) {
            System.out.println(racingCar.getName() + " : " + printConcatenatedChar(flag, racingCar.getPosition()));
        }
    }

    public static void printWinner(RacingCarHandler racingCarHandler) {
        racingCarHandler.getWinners().forEach(car -> System.out.println(car.getName()));
    }

    private static String printConcatenatedChar(String flag, int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num ; i ++) {
            sb.append(flag);
        }

        return sb.toString();
    }
}
