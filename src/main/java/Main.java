import racingcar.domain.RacingGame;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGamePrinter;

public class Main {

    public static void main(String[] args) {
        String carNames = RacingGameInputView.getCarsName();
        int round = RacingGameInputView.getRound();

        RacingGame racingGame = new RacingGame(carNames, round);
        while (!racingGame.isEnd()) {
            racingGame.playRound();
            RacingGamePrinter.printAllCarStatus(racingGame.getCars());
        }
        int maxStatus = racingGame.getMaxStatusAmongPlayers();
        racingGame.findWinnerWithMaxStatus(maxStatus);
        RacingGamePrinter.printWinners(racingGame.getWinners());

    }
}
