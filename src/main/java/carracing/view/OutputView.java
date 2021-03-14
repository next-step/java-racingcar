package carracing.view;

import carracing.controller.dto.CarRacingResponse;
import carracing.controller.dto.RacingScoreInfo;
import carracing.controller.dto.RoundResultInfo;

import java.util.List;

public class OutputView {

    private static final String SCORE_LINE = "-";

    public void printCarRacingResult(CarRacingResponse carRacingResponse) {
        System.out.println("실행 결과");
        for (RoundResultInfo roundResultInfo : carRacingResponse.getRoundResultList()) {
            System.out.println("Round " + roundResultInfo.getRoundNumber());
            printRacingScore(roundResultInfo.getRacingScoreInfoList());
            System.out.println();
        }
    }

    private void printRacingScore(List<RacingScoreInfo> roundResultInfoList) {
        for (RacingScoreInfo racingScoreInfo : roundResultInfoList) {
            System.out.println(showScore(racingScoreInfo.getScore()));
        }
    }

    private String showScore(int score) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < score; i++) {
            line.append(SCORE_LINE);
        }
        return line.toString();
    }
}
