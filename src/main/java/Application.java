import domain.RacingCarGame;
import io.ConsoleScanner;
import io.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(ConsoleScanner.input());
        racingCarGame.startGame();
    }
}
