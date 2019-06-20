package study.racingcar.view.output;

import study.racingcar.domain.Cars;
import study.racingcar.domain.CarsRacingLog;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public interface ResultView {
    void printInit();
    void printRacingLogs(List<CarsRacingLog> carsRacingLogs);
    void printWinners(Cars winners);
}
