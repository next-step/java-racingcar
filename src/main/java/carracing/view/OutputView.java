package carracing.view;

import carracing.controller.dto.CarRacingResponse;
import carracing.controller.dto.RacingScoreInfo;
import carracing.controller.dto.RoundResultInfo;

import java.util.List;

public class OutputView {

    private static final String SCORE_LINE = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printCarRacingResult(CarRacingResponse carRacingResponse) {
        System.out.println("\n실행 결과");
        for (RoundResultInfo roundResultInfo : carRacingResponse.getRoundResultList()) {
            System.out.println("Round " + roundResultInfo.getRoundNumber());
            printRacingScore(roundResultInfo.getRacingScoreInfoList());
            System.out.println();
        }
        printWinners(carRacingResponse.getWinnerList());
    }

    private void printRacingScore(List<RacingScoreInfo> roundResultInfoList) {
        for (RacingScoreInfo racingScoreInfo : roundResultInfoList) {
            System.out.println(racingScoreInfo.getCarName() + " : " + showScore(racingScoreInfo.getScore()));
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
