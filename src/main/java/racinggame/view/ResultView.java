package racinggame.view;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Car;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.history.RoundHistory;
import racinggame.domain.winner.Winner;
import racinggame.domain.winner.Winners;

public class ResultView {

    private static final String RUN_RESULT_TEXT = "실행 결과";
    private static final String LOCATION_STAGE = "-";
    private static final String WINNER_TEXT = "최종 우승자: ";
    private static final String WINNER_JOIN_CHAR = ", ";
    private static final String CAR_NAME_CAR_STATE_BETWEEN_TEXT = " : ";

    public ResultView() {

    }

    private void printCarsLocation(final List<RoundHistory> roundHistories) {
        for (RoundHistory roundHistory : roundHistories) {
            printCarNames(roundHistory);
            System.out.println();
        }
    }

    private void printCarNames(final RoundHistory roundHistory) {
        for (Car car : roundHistory.getRoundHistory()) {
            System.out.print(car.getCarName() + CAR_NAME_CAR_STATE_BETWEEN_TEXT);
            printLocation(car.getLocation());
        }
    }

    private void printLocation(final int location) {
        for (int i = 0; i < location; i++) {
            System.out.print(LOCATION_STAGE);
        }
        System.out.println();
    }

    private void printWinner(final Winners winners) {
        List<String> winnerNames = new ArrayList<>();
        System.out.print(WINNER_TEXT);
        for (Winner winner : winners.getWinners()) {
            winnerNames.add(winner.getWinnerName());
        }
        System.out.println(String.join(WINNER_JOIN_CHAR, winnerNames));
    }

    public void printResult(RoundHistories roundHistories) {
        System.out.println(RUN_RESULT_TEXT);
        this.printCarsLocation(roundHistories.getAllRoundHistory());
        this.printWinner(roundHistories.findWinners());
    }
}
