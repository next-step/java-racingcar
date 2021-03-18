package carracing.view;

import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RoundResult;

import java.util.List;

public class OutputView {

    private static final String SCORE_LINE = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printCarRacingResult(RacingResult racingResult) {
        System.out.println("\n실행 결과");
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            System.out.println("Round " + roundResult.getRoundNumber());
            printRacingScore(roundResult.getRacingScoreList());
            System.out.println();
        }
        printWinners(racingResult.getWinnerNameList());
    }

    private void printRacingScore(List<RacingScore> racingScoreList) {
        for (RacingScore racingScore : racingScoreList) {
            System.out.println(racingScore.getCarName() + " : " + showScore(racingScore.getScore()));
        }
    }

    private String showScore(int score) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < score; i++) {
            line.append(SCORE_LINE);
        }
        return line.toString();
    }

    private void printWinners(List<String> winnerList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            stringBuilder.append(WINNER_DELIMITER);
            stringBuilder.append(winnerList.get(i));
        }
        System.out.println(stringBuilder.toString() + "가 최종 우승했습니다.");
    }
}
