package racing4;

import racing4.application.Race4Service;
import racing4.domain.Race4Car;
import racing4.domain.Race4Command;
import racing4.view.InputView;
import racing4.view.ResultView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCar4Application {
    public static void main(String[] args) {
        Race4Command race4Command = InputView.input();
        List<Race4Car> race4Cars = Race4Car.makeCarsBy(race4Command.getCarNames());

        ResultView.displayExecutionResultMessage();
        IntStream.range(0, race4Command.getTryCount())
                 .forEach(i -> {
                     Race4Service.playGame(race4Cars);
                     ResultView.displayRoundResult(race4Cars);
                 });
        ResultView.displayWinner(race4Cars);
    }
}
