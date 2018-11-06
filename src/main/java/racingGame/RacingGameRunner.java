package racingGame;

import racingGame.view.InputView;
import racingGame.view.QuestionType;
import racingGame.view.ResultView;

public class RacingGameRunner {

    public static void main(String args[]) {
        String[] carNames = InputView.inputStrings(QuestionType.CAR_NAMES.getQuestion());
        int times = InputView.inputInteger(QuestionType.TIMES.getQuestion());

        RacingGame racingGame = new RacingGame(carNames, times);

        System.out.println("\n실행 결과");
        while (racingGame.hasRemainTime()) {
            racingGame.move();
            ResultView.logRace(racingGame.getRacingCarSnapshot());
        }

        try {
            ResultView.logChampion(racingGame.getChampionCarNames());
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
