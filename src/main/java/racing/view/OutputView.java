package racing.view;

import java.util.List;
import racing.domain.CarHistory;

public class OutputView {

    private static final String SEPARATOR_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MOVE_STATE = "-";

    private OutputView() {
    }

    public static void printGameResult(List<List<CarHistory>> raceHistories) {
        System.out.println("\n실행 결과");
        for (List<CarHistory> carHistories : raceHistories) {
            printCarHistories(carHistories);
            System.out.println();
        }
    }

    private static void printCarHistories(List<CarHistory> carHistories) {
        for (CarHistory carHistory : carHistories) {
            printCarHistory(carHistory);
            System.out.println();
        }
    }

    private static void printCarHistory(CarHistory carHistory) {
        System.out.print(carHistory.getName() + SEPARATOR_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < carHistory.getPosition(); i++) {
            System.out.print(MOVE_STATE);
        }
    }

    public static void printWinners(List<String> winners) {
        final String resultOfWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + resultOfWinners);
    }
}
