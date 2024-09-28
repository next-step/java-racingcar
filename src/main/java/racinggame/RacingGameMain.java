package racinggame;

import racinggame.ui.ConsoleMessageWriter;
import racinggame.ui.RacingConsoleMessageReader;

public class RacingGameMain {
    public static void main(String[] args) {
        final RacingGameRunner runner = new RacingGameRunner(
            new RacingConsoleMessageReader(System.in),
            new ConsoleMessageWriter()
        );
        runner.play();
    }
}
