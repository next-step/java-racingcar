package study.racingcar.output;

import study.racingcar.model.Car;
import study.racingcar.model.CarRacingLog;
import study.racingcar.model.Cars;
import study.racingcar.model.CarsRacingLog;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ConsoleGameStatusResultView implements ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_TEXT = "-";
    private static final String SEPARATOR = " : ";
    private static final String WINNERS_DELIMITER = " ,";
    private static final String FINAL_MESSAGE_SUFFIX = "가 최종 우승했습니다.";

    @Override
    public void printInit() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    @Override
    public void printRacingLogs(List<CarsRacingLog> carsRacingLogs) {
        for (CarsRacingLog carsRacingLog : carsRacingLogs) {
            this.print(carsRacingLog);
        }
    }

    @Override
    public void printWinners(Cars winners) {
        final StringBuilder sb = new StringBuilder();

        int index = 0;
        for (Car car : winners.getCars()) {
            if (index != 0) {
                sb.append(WINNERS_DELIMITER);
            }

            sb.append(car.getName());
            index++;
        }

        sb.append(FINAL_MESSAGE_SUFFIX);

        System.out.println(sb.toString());
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
        final String carName = carRacingLog.getCar().getName();
        final StringBuilder sb = new StringBuilder();

        sb.append(carName);
        sb.append(SEPARATOR);

        int movedPosition = carRacingLog.getPosition();
        while (movedPosition-- > 0) {
            sb.append(POSITION_TEXT);
        }

        return sb.toString();
    }
}
