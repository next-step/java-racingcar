package racingcar;

import java.util.List;

public class ResultView {

    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String WINNER_POSITION_DELIMITER = ", ";


    public void printHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTurn(TurnResult turnResult) {
        for (CarStatus status : turnResult.statuses()) {
            System.out.println(toLine(status));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(toWinnerMessage(winners));
    }

    static String toWinnerMessage(List<String> names) {
        return String.join(WINNER_POSITION_DELIMITER, names) + "가 최종 우승했습니다.";
    }

    static String toLine(CarStatus status) {
        return status.name() + NAME_POSITION_DELIMITER + toDashes(status.position());
    }

    static String toDashes(int position) {
        return "-".repeat(position);
    }
}
