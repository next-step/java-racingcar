package study.racingcar.output;

import study.racingcar.model.CarRacingLog;
import study.racingcar.model.CarsRacingLog;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ConsoleGameStatusResultView implements ResultView {
    private static final String POSITION_TEXT = "-";

    @Override
    public void printInit() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void print(List<CarsRacingLog> carsRacingLogs) {
        for (CarsRacingLog carsRacingLog : carsRacingLogs) {
            this.print(carsRacingLog);
        }
    }

    private void print(CarsRacingLog carsRacingLog) {
        for (CarRacingLog carRacingLog : carsRacingLog.getCarRacingLogs()) {
            print(carRacingLog);
        }

        System.out.println();
    }

    private void print(CarRacingLog carRacingLog) {
        System.out.println(convertPositionToString(carRacingLog));
    }

    private String convertPositionToString(CarRacingLog carRacingLog) {
        final StringBuilder sb = new StringBuilder();

        int movedPosition = carRacingLog.getPosition();
        while (movedPosition-- > 0) {
            sb.append(POSITION_TEXT);
        }

        return sb.toString();
    }
}
