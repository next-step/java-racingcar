package study.step4;

public class RacingGameLauncher {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames() , InputView.inputTryTime());
        RacingGameProgress racingGameProgress = new RacingGameProgress(racingGame);
        RacingGameResult racingGameResult = racingGameProgress.runGames(new RandomCarMoveCondition());

        ResultView.racingResultPrint(racingGameResult);
    }
}
