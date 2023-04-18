import racingCarGame.domain.RacingCarGame;
import racingCarGame.view.ConsoleScanner;
import racingCarGame.view.ConsoleWriter;
import racingCarGame.view.InputView;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = ConsoleScanner.input();
        RacingCarGame racingCarGame = new RacingCarGame(inputView);

        ConsoleWriter.writeHeader();
        for (int i = 1; i <= inputView.getTryCount(); i++) {
            racingCarGame.race();
            ConsoleWriter.writeGameInformation(racingCarGame.getCars());
        }
        ConsoleWriter.writeWinner(racingCarGame.findWinner());
    }
}
