package step3;


public class RacingCarGameExecute {
    private static final String COMMA = ",";

    private static RacingCarGameUi racingCarGameUi;
    private static RacingCarGame racingCarGame;

    public static void main(String[] args) {
        initGameExecute();
        execFindWinnerRacingGame();
    }

    public static void initGameExecute() {
        racingCarGameUi = new RacingCarGameUi();
    }

    public static void execFindWinnerRacingGame() {
        String allRacingCarName = racingCarGameUi.askRacingCarName();
        String[] raicingCarNames = allRacingCarName.split(COMMA);
        racingCarGame = new RacingCarGame(new RacingCars(raicingCarNames), new Attempt(racingCarGameUi.askAttemptNumber()));
        Attempt attempt = racingCarGame.getAttempt();

        racingCarGameUi.printExecuteResult();

        while (!attempt.isEnd()) {
            racingCarGame.play();
            racingCarGameUi.printRacingCarNameAndGameResult(racingCarGame.getRacingCars());
        }
      //  racingCarGameUi.printRacingCarWinnerResult(racingCarGame.findWinner());
    }

    public static void execBasicRacingGame() {
        int carNumber = racingCarGameUi.askRacingCarNumber();
        racingCarGame = new RacingCarGame(new RacingCars(carNumber), new Attempt(racingCarGameUi.askAttemptNumber()));
        Attempt attempt = racingCarGame.getAttempt();

        racingCarGameUi.printExecuteResult();

        while (!attempt.isEnd()) {
            racingCarGame.play();
            racingCarGameUi.printRacingCarGameResult(racingCarGame.getRacingCars());
        }
    }
}
