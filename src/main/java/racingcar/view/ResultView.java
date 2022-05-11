package racingcar.view;

import racingcar.domain.car.RacingRecord;
import racingcar.domain.racinggame.TryNumber;
import racingcar.domain.racinggame.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final String HEAD = "\n실행 결과\n";
    private static final String COMMA = ", ";
    private static final String WINNER_COMMENT = "가 최종 우승했습니다.\n";
    private static final String SEMICOLON = " : ";
    private static final String NEXT_LINE = "\n";
    private static final String INSTANCE_ERROR_MESSAGE = "InputView 클래스틑 인스턴스화 할수 없습니다";

    private static StringBuilder strBuilder;

    private ResultView() {
        throw new AssertionError(INSTANCE_ERROR_MESSAGE);
    }


    public static void printHead() {
        System.out.print(HEAD);
    }


    public static void printRacingGameResult(Cars cars, TryNumber tryNumber) {
        strBuilder = new StringBuilder(EMPTY);

        for (int i = 0; i < tryNumber.getValue(); i++) {
            printRacingRecordByCar(cars.getCars(), i);
        }

        System.out.println(strBuilder.toString());
    }

    private static void printRacingRecordByCar(List<Car> cars, int tryNumber) {
        for (Car car : cars) {
            strBuilder.append(car.getParticipant())
                    .append(SEMICOLON);
            printRacingRecord(car.readRacingRecord(tryNumber));
        }
        strBuilder.append(NEXT_LINE);
    }

    private static void printRacingRecord(RacingRecord record) {
        strBuilder.append(DASH.repeat(Math.max(0, record.readPosition())))
                .append(NEXT_LINE);
    }

    public static void printWinners(Winners winners) {
        strBuilder = new StringBuilder(EMPTY);

        int idx = 0;
        for (Car winner : winners.getWinners()) {
            strBuilder.append(winner.getParticipant());
            addComma(idx, winners.getLastIndex());
            idx++;
        }

        strBuilder.append(WINNER_COMMENT);

        System.out.println(strBuilder.toString());
    }

    private static void addComma(int idx, int lastIdx) {
        if (idx != lastIdx) {
            strBuilder.append(COMMA);
        }
    }

}
