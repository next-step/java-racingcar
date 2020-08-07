package racingcar.view;

import racingcar.model.RacingRound;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RUN_MARK = "-";
    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ",";

    private static List<RacingRound> racingResults;

    public ResultView(List<RacingRound> racingResults) {
        this.racingResults = racingResults;
    }

    public void displayRacing() {
        StringBuilder builder = new StringBuilder();
        int round = 1;
        System.out.println("실행 결과");

        for (RacingRound racingRound : racingResults) {
            builder.append("[ROUND ").append(round++).append("]").append("\n");
            builder.append(printRoundResult(racingRound)).append("\n");
        }

        builder.append("*** 최종 우승자는 ").append(getFinalWinners()).append(" 입니다. ***");
        System.out.println(builder.toString());
    }

    public String printRoundResult(RacingRound racingRound) {
        StringBuilder builder = new StringBuilder();
        racingRound.getRacingCars()
                .forEach(racingCar -> builder
                        .append(makeCarResult(racingCar.getCarName(), racingCar.getCarPosition()))
                        .append("\n")
                );
        return builder.toString();
    }


    public String makeCarResult(String carName, int position) {
        StringBuilder builder = new StringBuilder();
        builder.append(carName).append(SEPARATOR);
        for (int i = 0; i < position; i++) {
            builder.append(RUN_MARK);
        }
        return builder.toString();
    }

    private String getFinalWinners() {
            List<String> bestScoreCarNames = racingResults.get(racingResults.size() - 1)
                    .findBestScoreCars()
                    .stream()
                    .map(car -> car.getCarName())
                    .collect(Collectors.toList());
            return String.join(DELIMITER, bestScoreCarNames);
    }
}
