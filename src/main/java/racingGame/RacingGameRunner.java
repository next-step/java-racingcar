package racingGame;

import racingGame.model.RacingCarDTO;
import racingGame.util.RacingCarUtils;
import racingGame.view.InputView;
import racingGame.view.QuestionType;
import racingGame.view.ResultView;

import java.util.List;

public class RacingGameRunner {

    public static void main(String args[]) {
        String[] carNames = InputView.inputStrings(QuestionType.CAR_NAMES.getQuestion());
        int times = InputView.inputInteger(QuestionType.TIMES.getQuestion());

        RacingGame racingGame = new RacingGame(carNames, times);

        System.out.println("\n실행 결과");
        while (racingGame.hasRemainTime()) {
            racingGame.move();
            ResultView.logRace(racingGame.getRacingCarSnapshots());
        }

        List<RacingCarDTO> snapshots = null;
        try {
            snapshots = racingGame.getFinishedCarSnapshots();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        } finally {
            int highestPosition = RacingCarUtils.getHighestPosition(snapshots);
            ResultView.logChampion(RacingCarUtils.filterRacingCar(snapshots, highestPosition));
        }

    }
}
