package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.Car;

public class RacingRecord {

    private static final String ENTER = "\n";
    private static final String RESULT_LINE = "%s : %s" + ENTER;
    private static final String DASH = "-";
    private final StringBuilder raceRecord;

    public RacingRecord() {
        raceRecord = new StringBuilder();
    }

    public void appendRecord(List<Car> cars) {
        cars.forEach(car
            -> raceRecord.append(String.format(RESULT_LINE, car.getName(), convertPositionToDashString(car.getPosition()))));
        raceRecord.append(ENTER);
    }

    private String convertPositionToDashString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    public String getResultRecord() {
        return this.raceRecord.toString();
    }
}
