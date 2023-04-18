package step4;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private List<Cars> racingLog;
    private List<String> winners;

    public ResultView() {
        this.racingLog = new ArrayList<>();
    }

    public void printScore(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + "  " + "-".repeat(car.getProgress()));
        }
        System.out.println("");
    }

    public void logScore(Cars cars) {
        racingLog.add(cars);
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }

    public void printResult() {

        System.out.println("실행결과");
        for (Cars cars : racingLog) {
            printScore(cars);
        }
        printWinner();
    }

    private void printWinner() {
        StringBuilder winner = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winner.append(winners.get(i));
            if (i < winners.size() - 1) winner.append(",");
        }
        System.out.println(winner + "가 촤종 우승했습니다.");
    }
}
