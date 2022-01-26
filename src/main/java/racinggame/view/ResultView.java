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

    private List<RoundHistory> roundHistories = new ArrayList<>();

    public ResultView() {
    }

    public void captureResult(Cars cars) {
        List<CarHistory> carHistories = new ArrayList<>();

        for (Car car : cars.getCars()) {
            carHistories.add(new CarHistory(car));
        }
        roundHistories.add(new RoundHistory(carHistories));

    }

    public void printCarsLocation() {
        for (RoundHistory roundHistory : roundHistories) {
            roundHistory(roundHistory);
            System.out.println();
        }

    }

    private void roundHistory(RoundHistory roundHistory) {
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
        List<String> winnerNameList = new ArrayList<>();
        String winnerNames = "";
        System.out.print("최종 우승자: ");
        for (Winner winner : winners.getWinners()) {
            winnerNameList.add(winner.getWinnerName());
        }
        winnerNames = String.join(", ", winnerNameList);
        System.out.println(winnerNames);
    }

}
