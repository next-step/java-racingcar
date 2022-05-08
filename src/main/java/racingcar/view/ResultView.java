package racingcar.view;

import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

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

    // 인스턴스화 방지용
    private ResultView() {
        throw new AssertionError(INSTANCE_ERROR_MESSAGE);
    }


    public static void printHead() {
        System.out.print(HEAD);
    }


    public static void printCars(Cars cars) {
        strBuilder = new StringBuilder(EMPTY);

        for (Car car : cars.getCars()) {
            strBuilder.append(car.getParticipant());
            strBuilder.append(SEMICOLON);
            strBuilder.append(DASH.repeat(Math.max(0, car.getPosition().getValue())));
            strBuilder.append(NEXT_LINE);
        }

        System.out.println(strBuilder.toString());
    }

    public static void printWinners(Winners winners) {
        strBuilder = new StringBuilder("\n");

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
