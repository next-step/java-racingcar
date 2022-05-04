package racingcar.v2.view;

import racingcar.v2.domain.car.Car;
import racingcar.v2.domain.car.Position;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final String HEAD = "\n실행 결과\n";
    private static final String COMMA = ", ";
    private static final String WINNER_COMMENT = "가 최종 우승했습니다.\n";
    private static final String SEMICOLON = " : ";

    private static StringBuilder strBuilder;

    public static void printHead() {
        System.out.print(HEAD);
    }
    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getParticipant());
            System.out.print(SEMICOLON);
            printDash(car.getPosition());
        }
        System.out.println(EMPTY);
    }



    private static void printDash(Position position) {
        for (int i = 0; i < position.getPosition(); i++) {
            System.out.print(DASH);
        }
        System.out.println(EMPTY);
    }

    public static void printWinners(List<Car> winners) {
        strBuilder = new StringBuilder("\n");

        int idx = 0;
        for (Car winner : winners) {
            strBuilder.append(winner.getParticipant());
            addComma(idx, winners.size() - 1);
            idx++;
        }

        strBuilder.append(WINNER_COMMENT);

        System.out.println(strBuilder.toString());
    }

    private static void addComma(int idx, int lastIdx) {
        if(idx != lastIdx) {
            strBuilder.append(COMMA);
        }
    }
}
