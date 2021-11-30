package step3;


public class RacingCarGameExecute {
    private static RacingCarGameUi racingCarGameUi;
    private static RacingCarGame racingCarGame;

    public static void main(String[] args) {
        initGameExecute();
        execFindWinnerRacingGame();
    }

    public static void initGameExecute() {
        racingCarGameUi = new RacingCarGameUi();
        racingCarGame = new RacingCarGame();
    }

    public static void execFindWinnerRacingGame() {
        racingCarGame.ready(racingCarGameUi.askRacingCarName(), racingCarGameUi.askAttemptNumber());
        Attempt attempt = racingCarGame.getAttempt();

        racingCarGameUi.printExecuteResult();

        while (attempt.isEnd() == false) {
            racingCarGame.play();
            racingCarGameUi.printRacingCarNameAndGameResult(racingCarGame.getRacingCarList());
        }
        racingCarGameUi.printRacingCarWinnerResult(racingCarGame.findWinner());
    }

    public static void execBasicRacingGame() {
        racingCarGame.ready(racingCarGameUi.askRacingCarNumber(), racingCarGameUi.askAttemptNumber());
        Attempt attempt = racingCarGame.getAttempt();

        racingCarGameUi.printExecuteResult();

        while (attempt.isEnd() == false) {
            racingCarGame.play();
            racingCarGameUi.printRacingCarGameResult(racingCarGame.getRacingCarList());
        }
    }
}
