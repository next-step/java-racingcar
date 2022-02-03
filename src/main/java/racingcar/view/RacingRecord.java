package racingcar.view;

import java.util.List;
import racingcar.domain.car.Car;

public class RacingRecord {

    private static final String ENTER = "\n";
    private static final String RESULT_LINE = "%s : %s" + ENTER;
    private static final String DASH = "-";
    private static final StringBuilder raceRecord = new StringBuilder();

    public static void appendRecord(List<Car> cars) {
        cars.forEach(car
            -> raceRecord.append(String.format(RESULT_LINE, car.getName(), convertPositionToDashString(car.getPosition()))));
        raceRecord.append(ENTER);
    }

    private static String convertPositionToDashString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    public static String getResultRecord() {
        return raceRecord.toString();
    }
}
