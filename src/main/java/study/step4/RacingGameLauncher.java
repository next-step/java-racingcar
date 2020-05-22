package study.step4;

public class RacingGameLauncher {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames() , InputView.inputTryTime());

        RacingGameProgress racingGameProgress = new RacingGameProgress(racingGame);

        ResultView.racingResultPrint(racingGameProgress.gameStart(new RandomCarMoveCondition()));
    }
}
