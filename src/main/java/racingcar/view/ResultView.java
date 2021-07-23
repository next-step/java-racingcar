package racingcar.view;

import java.util.List;
import racingcar.domain.vehicle.Cars;

public class ResultView {

    private static final char PRINT_FLAG = '-';

    public static void printWinners(List<String> carNames) {
        String winnerNames = String.join(",", carNames);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public static void pirntProgress(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.getCarName(i);
            int distance = cars.getDistance(i);

            System.out.println(carName + " : " + getDistanceString(distance));
        }
    }

    private static String getDistanceString(int distance) {
        StringBuilder distanceString = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            distanceString.append(PRINT_FLAG);
        }

        return distanceString.toString();
    }

    public static void println(String string) {
        System.out.println(string);
    }
}
