package racingcar.view;

import racingcar.dto.CarScore;
import racingcar.dto.FinalScoreBoard;
import racingcar.dto.ScoreBoardPerPlay;

public class ResultView {

    private static final String DISTANCE_REPRESENTATION = "-";

    private static final String EMPTY_SPACE = " ";

    public void printFinalResult(FinalScoreBoard finalScoreBoard){
        System.out.println(Message.FINAL_RESULT.getDescription());
        finalScoreBoard.getAllScore().forEach(this::printScoreBoardPerPlay);
    }

    private void printScoreBoardPerPlay(ScoreBoardPerPlay scoreBoardPerPlay) {
        System.out.printf("%s회 %n",scoreBoardPerPlay.getPlayNumber());
        scoreBoardPerPlay.getScoreList().forEach(this::printIndividualScore);
    }

    private void printIndividualScore(CarScore carScore) {
        System.out.printf("차이름 %s : %s %n",
                carScore.getName(),createDistanceLine(carScore.getTravelledDistance()));
    }

    private String createDistanceLine (int times) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < times; ++i) {
            b.append(DISTANCE_REPRESENTATION);
            b.append(EMPTY_SPACE);
        }
       return b.toString();
    }
}
