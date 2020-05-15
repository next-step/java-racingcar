package racing.view;

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
        racingGameResults.forEach(racingGameResult -> this.outputCarPosition(racingGameResult.getCarName(), racingGameResult.getPosition()));
        System.out.println();
    }

    private void outputCarPosition(String name, int position) {
        StringBuilder stringBuilder = this.appendCarPosition(name, position);
        System.out.println(stringBuilder);
    }

    private StringBuilder appendCarPosition(String name, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(COLON);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        return stringBuilder;
    }

    public void printRacingWinners(List<RacingGameResult> racingGameResults, int maxPosition) {
        List<RacingGameResult> winners = this.findWinners(racingGameResults, maxPosition);
        StringBuilder stringBuilder = this.appendWinnerNames(winners);
        System.out.println(stringBuilder);
    }

    private List<RacingGameResult> findWinners(List<RacingGameResult> racingGameResults, int maxPosition) {
        return racingGameResults.stream()
                .filter(racingGameResult -> racingGameResult.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private StringBuilder appendWinnerNames(List<RacingGameResult> winners) {
        String winnerNames = winners.stream()
                .map(winner -> winner.getCarName())
                .collect(Collectors.joining(", "));
        StringBuilder stringBuilder = new StringBuilder(winnerNames);
        stringBuilder.append( "가 최종 우승했습니다.");
        return stringBuilder;
    }
}
