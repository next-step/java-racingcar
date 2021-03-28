package racingcar.view;

import racingcar.dto.Round;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RACE_TRACK = "-";
    private static final String CAR_NAME_DELIMITER = ": ";
    private static final String WINNER_DELIMITER = ", ";

    private List<Round> rounds;

    public ResultView(List<Round> rounds) {
        this.rounds = rounds;
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printGameResult() {
        for (Round round : rounds) {
            printRound(round);
        }
        printGameWinners(rounds);
    }

    public void printGameWinners(List<Round> rounds) {
        String winners = winnersToString(rounds);
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private String winnersToString(List<Round> rounds) {
        Map<String, Integer> finalRound = Round.roundResult(rounds.get(rounds.size() - 1));
        List<String> winnerList = Round.winners(finalRound);
        return String.join(WINNER_DELIMITER, winnerList);
    }

    private void printRound(Round round) {
        for (Map.Entry<String, Integer> stringIntegerEntry : Round.roundResult(round).entrySet()) {
            printTrack(stringIntegerEntry);
        }
        System.out.println();
    }

    private void printTrack(Map.Entry<String, Integer> roundResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(roundResult.getKey()).append(CAR_NAME_DELIMITER);
        for (int i = 0; i < roundResult.getValue(); i++) {
            sb.append(RACE_TRACK);
        }
        System.out.println(sb.toString());
    }
}
