package racing.view;

import racing.dto.RaceWinnerResult;
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
        racingGameResults.forEach(racingGameResult -> this.outputCarPosition(racingGameResult));
        System.out.println();
    }

    private void outputCarPosition(RacingGameResult racingGameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = this.appendCarPositions(stringBuilder, racingGameResult);
        System.out.println(stringBuilder);
    }

    private StringBuilder appendCarPositions(StringBuilder stringBuilder, RacingGameResult racingGameResult) {
        for (int i = 0; i < racingGameResult.getCarRaceResultSize(); i++) {
            stringBuilder = this.appendCarName(stringBuilder, racingGameResult.getCarName(i));
            stringBuilder = this.appendHyphen(stringBuilder, racingGameResult.getCarPosition(i));
        }
        return stringBuilder;
    }

    private StringBuilder appendCarName(StringBuilder stringBuilder, String carName) {
        stringBuilder.append(carName);
        stringBuilder.append(COLON);
        return stringBuilder;
    }

    private StringBuilder appendHyphen(StringBuilder stringBuilder, int position) {
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder;
    }

    public void printRacingWinners(RaceWinnerResult raceWinnerResult) {
        String winnerNames = raceWinnerResult.getWinnerNames()
                .stream()
                .collect(Collectors.joining(", "));
        StringBuilder stringBuilder = new StringBuilder(winnerNames);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }
}
