package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Record;
import racingcar.domain.Records;

public class ResultView {
    private final static String LOCATION_EXPRESSION = "-";
    private final static String SET_OUTPUT_RESULT = "실행 결과";

    private static void printStart() {
        System.out.println(SET_OUTPUT_RESULT);
    }

    public static void printRecords(Records records) {
        printStart();
        for (Record record : records.getRecords()) {
            printRecord(record);
            System.out.println();
        }
        printWinners(records);

    }

    private static void printWinners(Records records) {
        Record record = records.lastRecord();
        String result = "";
        for (Car car : record.getRecord().winners()) {
            result = result.concat(car.getName());
            result = result.concat(", ");
        }
        result = result.substring(0, result.length() - 2);
        result = result.concat("가 최종 우승했습니다.");
        System.out.println(result);

    }

    private static void printRecord(Record record) {
        Cars cars = record.getRecord();
        for (Car car : cars.getCars()) {
            printLocationToExpression(car);
        }
    }

    private static void printLocationToExpression(Car car) {
        String result = car.getName();
        result = result.concat(" : ");
        for (int i = 0; i < car.getCurrentLocation(); i++) {
            result = result.concat(LOCATION_EXPRESSION);
        }
        System.out.println(result);
    }
}
