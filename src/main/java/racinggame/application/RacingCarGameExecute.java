package racinggame.application;


import racinggame.domain.Attempt;
import racinggame.domain.RacingCarGame;
import racinggame.domain.RacingCars;
import racinggame.view.RacingCarGameExecuteConst;
import racinggame.view.RacingCarGameUi;

public class RacingCarGameExecute {
    private static RacingCarGameUi racingCarGameUi;
    private static RacingCarGame racingCarGame;

    public static void main(String[] args) {
        initGameExecute();
        execBasicRacingGame();
    }

    public static void initGameExecute() {
        racingCarGameUi = new RacingCarGameUi();
    }

    public static void execFindWinnerRacingGame() {
        String allRacingCarName = racingCarGameUi.askRacingCarName();
        String[] raicingCarNames = allRacingCarName.split(RacingCarGameExecuteConst.COMMA);
        racingCarGame = new RacingCarGame(new RacingCars(raicingCarNames), new Attempt(racingCarGameUi.askAttemptNumber()));

        racingCarGameUi.printExecuteResult();

        while (!racingCarGame.isEnd()) {
            racingCarGame = racingCarGame.play();
            racingCarGameUi.printRacingCarNameAndGameResult(racingCarGame.getRacingCars());
        }
        racingCarGameUi.printRacingCarWinnerResult(racingCarGame.findWinner());
    }

    public static void execBasicRacingGame() {
        int carNumber = racingCarGameUi.askRacingCarNumber();
        racingCarGame = new RacingCarGame(new RacingCars(carNumber), new Attempt(racingCarGameUi.askAttemptNumber()));

        racingCarGameUi.printExecuteResult();

        while (!racingCarGame.isEnd()) {
            racingCarGame = racingCarGame.play();
            racingCarGameUi.printRacingCarGameResult(racingCarGame.getRacingCars());
        }
    }
}
