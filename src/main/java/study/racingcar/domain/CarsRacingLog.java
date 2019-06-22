package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class CarsRacingLog {
    private List<CarRacingLog> carRacingLogs;

    public CarsRacingLog() {
        carRacingLogs = new ArrayList<>();
    }

    public boolean add(CarRacingLog carRacingLog) {
        return this.carRacingLogs.add(carRacingLog);
    }

    public List<CarRacingLog> getCarRacingLogs() {
        return carRacingLogs;
    }

    public int getMaxPosition() {
        return carRacingLogs.stream()
                .map(CarRacingLog::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }

}
