package racingcar.view;

import racingcar.dto.CarScore;
import racingcar.dto.FinalScoreBoard;
import racingcar.dto.ScoreBoardPerPlay;
import racingcar.utils.StringUtil;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_REPRESENTATION = "-";

    private static final String EMPTY_SPACE = " ";

    private static final String NAME_SEPARATOR = ",";

    public void printFinalResult(FinalScoreBoard finalScoreBoard) {
        System.out.println(MessageConstant.FINAL_RESULT);
        printScoreBoardPerPlay(finalScoreBoard.getAllScore());
        printWinner(finalScoreBoard.getFinalWinner());
    }

    private void printWinner(List<CarScore> carScoreList) {
        System.out.println();
        System.out.printf("%s가 최종 우숭했습니다. %n", extractWinnerNameToString(carScoreList));
    }

    private void printScoreBoardPerPlay(List<ScoreBoardPerPlay> scoreBoardPerPlayList) {
        for (ScoreBoardPerPlay scoreBoardPerPlay : scoreBoardPerPlayList) {
            System.out.printf("%s회 %n", scoreBoardPerPlay.getPlayNumber());
            scoreBoardPerPlay.getScoreList()
                    .forEach(this::printIndividualScore);
        }
    }

    private void printIndividualScore(CarScore carScore) {
        System.out.printf("%s : %s %n", carScore.getCarName(), createDistanceLine(carScore.getTravelledDistance()));
    }

    private String extractWinnerNameToString(List<CarScore> carScoreList) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < carScoreList.size(); ++i) {
            b.append(carScoreList.get(i).getCarName());
            b.append(NAME_SEPARATOR);
        }
        return b.toString().replaceAll(",$", "");
    }

    private String createDistanceLine(int times) {
        return StringUtil.repeat(DISTANCE_REPRESENTATION + EMPTY_SPACE, times);
    }
}
