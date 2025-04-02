package racingcar.view;

import java.util.List;

import racingcar.domain.*;
import racingcar.utils.StringUtils;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String HYPHEN = "-";
    private static final String INFIX = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printRecords(RaceRecords records) {
        System.out.println(RESULT);
        records.getValues()
            .forEach(ResultView::printRecord);
    }

    private static void printRecord(RaceRecord record) {
        printCars(record.getCars());
        System.out.println();
    }

    private static void printCars(Cars cars) {
        cars.getValues()
            .forEach(car -> print(car.getName(), car.getPositionValue()));
    }

    private static void print(String prefix, int count) {
        System.out.print(prefix);
        System.out.print(INFIX);
        printHyphens(count);
    }

    private static void printHyphens(int count) {
        System.out.println(HYPHEN.repeat(count));
    }

    public static void printWinner(List<String> values) {
        System.out.println(StringUtils.joinByComma(values) + WINNER_MESSAGE);
    }
}
