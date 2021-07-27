package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RaceWinners;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "\n실행 결과";
    private static final String SYMBOL = "-";

    private ResultView() {
    }

    public static void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionAsSymbol(car.getCarPosition()));
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(MESSAGE_RESULT);
    }

    public static void printRaceWinners(RaceWinners raceWinners) {
        System.out.printf("최종 우승자는 %s 입니다.", raceWinners.winnerNames());
    }

    private static String getPositionAsSymbol(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(SYMBOL);
        }
        return stringBuilder.toString();
    }
}
