package racing.view;

import racing.dto.CarRaceResult;
import racing.dto.RacingGameResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String COLON = " : ";

    public void printGuidance() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<RacingGameResult> racingGameResults) {
        racingGameResults.forEach(racingGameResult -> this.outputCarPosition(racingGameResult.getCarRaceResults()));
        System.out.println();
    }

    private void outputCarPosition(List<CarRaceResult> carRaceResults) {
        StringBuilder stringBuilder = this.appendCarPositions(carRaceResults);
        System.out.println(stringBuilder);
    }

    private StringBuilder appendCarPositions(List<CarRaceResult> carRaceResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CarRaceResult carRaceResult : carRaceResults) {
            stringBuilder.append(carRaceResult.getCarName());
            stringBuilder.append(COLON);
            stringBuilder = this.appendHyphen(stringBuilder, carRaceResult);
        }
        return stringBuilder;
    }

    private StringBuilder appendHyphen(StringBuilder stringBuilder, CarRaceResult carRaceResult) {
        for (int i = 0; i < carRaceResult.getPosition(); i++) {
            stringBuilder.append(HYPHEN);
        }
        stringBuilder.append("\n");
        return stringBuilder;
    }

    public void printRacingWinners(List<RacingGameResult> racingGameResult) {
        RacingGameResult lastRacingGameResults = this.findLastRacingGameResult(racingGameResult);
        List<CarRaceResult> winners = this.findWinners(lastRacingGameResults);
        StringBuilder stringBuilder = this.appendWinnerNames(winners);
        System.out.println(stringBuilder);
    }

    private RacingGameResult findLastRacingGameResult(List<RacingGameResult> racingGameResults) {
        int lastRound = racingGameResults.stream()
                .map(racingGameResult -> racingGameResult.getRound())
                .max(Integer::compareTo)
                .orElse(1);

        return racingGameResults.stream()
                .filter(racingGameResult -> racingGameResult.getRound() == lastRound)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private List<CarRaceResult> findWinners(RacingGameResult racingGameResults) {
        return racingGameResults.getCarRaceResults().stream()
                .filter(carRaceResult -> carRaceResult.getPosition() == racingGameResults.getMaxPosition())
                .collect(Collectors.toList());
    }

    private StringBuilder appendWinnerNames(List<CarRaceResult> winners) {
        String winnerNames = winners.stream()
                .map(winner -> winner.getCarName())
                .collect(Collectors.joining(", "));
        StringBuilder stringBuilder = new StringBuilder(winnerNames);
        stringBuilder.append( "가 최종 우승했습니다.");
        return stringBuilder;
    }
}
