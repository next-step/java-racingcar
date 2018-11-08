package racingGame;

import racingGame.service.RacingCarService;
import racingGame.view.InputView;
import racingGame.view.QuestionType;
import racingGame.view.ResultView;

public class RacingGameRunner {

    public static void main(String args[]) {
        String[] carNames = InputView.inputStrings(QuestionType.CAR_NAMES.getQuestion());
        int times = InputView.inputInteger(QuestionType.TIMES.getQuestion());

        RacingGame racingGame = new RacingGame(carNames, times);
        RacingCarService racingCarService = null;

        System.out.println("\n실행 결과");
        while (racingGame.hasRemainTime()) {
            racingGame.move();
            ResultView.logRace(racingGame.getRacingCarSnapshots());
        }

        try {
            racingCarService = new RacingCarService(racingGame.getFinishedCarSnapshots());
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        } finally {
            int highestPosition = racingCarService.getHighestPosition();
            ResultView.logChampion(racingCarService.extractCarNamesByPosition(highestPosition));
        }

    }
}
