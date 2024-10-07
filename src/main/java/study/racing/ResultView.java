package study.racing;

import study.racing.domain.Car;
import study.racing.domain.RacingHistory;

import java.util.List;

public class ResultView {

    final static String FORWARD_DASH = "-";

    public static void printView(RacingHistory racingHistory) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < racingHistory.getSize(); i++) {
            appendCarsInfo(stringBuilder, racingHistory.getRacingHistory(i));
        }
        System.out.print(stringBuilder);
    }

    private static void appendCarsInfo(StringBuilder stringBuilder, List<Car> cars) {
        for(Car car : cars) {
            appendCarInfo(stringBuilder, car);
        }
        stringBuilder.append("\n");
    }

    private static void appendCarInfo(StringBuilder stringBuilder, Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            stringBuilder.append(FORWARD_DASH);
        }
        stringBuilder.append("\n");
    }

}
