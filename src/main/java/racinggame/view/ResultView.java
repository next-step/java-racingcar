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
            System.out.print(car.getCarName() + " : " + "");
            printLocation(car.getLocation());
        }
    }

    private void printLocation(final int location) {
        for (int i = 0; i < location; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void printWinner(final Winners winners) {
        List<String> winnerNames = new ArrayList<>();
        System.out.print("최종 우승자: ");
        for (Winner winner : winners.getWinners()) {
            winnerNames.add(winner.getWinnerName());
        }
        System.out.println(String.join(", ", winnerNames));
    }

    public void printResult(RoundHistories roundHistories) {
        System.out.println(RUN_RESULT_TEXT);
        this.printCarsLocation(roundHistories.getAllRoundHistory());
        this.printWinner(roundHistories.findWinners());
    }

}
