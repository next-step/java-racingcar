package racinggame.view;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.CarHistory;
import racinggame.domain.RoundHistory;
import racinggame.domain.Winner;
import racinggame.domain.Winners;

public class ResultView {

    private static  final String RUN_RESULT_TEXT="실행 결과";


    public ResultView() {
        System.out.println(RUN_RESULT_TEXT);
    }



    public void printCarsLocation(List<RoundHistory> roundHistories) {
        for (RoundHistory roundHistory : roundHistories) {
            printCarNames(roundHistory);
            System.out.println();
        }

    }

    private void printCarNames(RoundHistory roundHistory) {
        for (CarHistory carHistory : roundHistory.getRoundHistory()) {
            System.out.print(carHistory.getCarName() + " : " + "");
            printLocation(carHistory.getLocation());
        }
    }

    private void printLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void printWinner(Winners winners) {
        List<String> winnerNames = new ArrayList<>();
        System.out.print("최종 우승자: ");
        for (Winner winner : winners.getWinners()) {
            winnerNames.add(winner.getWinnerName());
        }
        System.out.println(String.join(", ", winnerNames));
    }

}
