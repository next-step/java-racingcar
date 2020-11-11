package race.entry;

import race.logic.Race;
import race.logic.RandomEngine;
import race.ui.InputView;
import race.ui.OutputView;
import race.logic.Car;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stadium {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        Race race = new Race(RandomEngine::new, inputView.readCarNames());

        IntStream.range(0, inputView.readNumberIterations()).forEach(i -> {
                race.lap();
                outputView.showStatus(race.getCars());
        });

        outputView.showWinner(race.getFrontLine());
    }
}
