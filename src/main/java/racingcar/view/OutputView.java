package racingcar.view;

import racingcar.domain.dto.RacingResult;
import racingcar.domain.dto.RoundResult;
import racingcar.domain.dto.RoundScore;

public class OutputView {
    private static final String POSITION_DELIMITOR = "-";
    private static final String WINENR_DELIMITOR = ",";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printCarsPositionByRounds(RacingResult rounds) {
        System.out.println("실행 결과");

        for (RoundResult roundResult : rounds.getRoundResults()) {
            printCarsPositionByOneRound(roundResult);
        }
        printLastWinners(rounds);
    }

    private static void printLastWinners(RacingResult rounds) {
        System.out.println(String.join(WINENR_DELIMITOR, rounds.getWinnerNames()) + "가 최종 우승했습니다.");
    }

    public static void printCarsPositionByOneRound(RoundResult roundResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (RoundScore roundScore : roundResult.getRoundScores()) {
            stringBuilder.append(roundScore.getParticipantName())
                         .append(" : ")
                         .append(printCarPosition(roundScore.getPosition()))
                         .append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder printCarPosition(int positionNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < positionNumber; i++) {
            stringBuilder.append(POSITION_DELIMITOR);
        }
        return stringBuilder;
    }
}
