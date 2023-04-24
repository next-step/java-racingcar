package step5;

import java.util.List;

public class ResultView {
    private List<Cars> racingLog;
    private List<String> winners;
    private static final String PROGRESS_CHARACTER = "-";

    public ResultView(ResultDto resultDto) {
        this.racingLog = resultDto.getRacingLog();
        this.winners = resultDto.getWinners();
    }

    public void printResult() {

        System.out.println("실행결과");
        for (Cars cars : racingLog) {
            printScore(cars);
        }
        printWinner();
    }

    public void printScore(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + "  " + car.getProgressByCharacter(PROGRESS_CHARACTER));
        }
        System.out.println("");
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
