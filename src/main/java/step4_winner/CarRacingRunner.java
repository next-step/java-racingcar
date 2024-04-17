package step4_winner;

import step4_winner.domain.Car;
import step4_winner.domain.Race;
import step4_winner.view.InputView;
import step4_winner.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingRunner {
    private final InputView inputView;
    private final ResultView resultView;
    private final Race race;
    private final int tries;

    public CarRacingRunner(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.race = prepareRace();
        this.tries = prepareTries();
    }

    private Race prepareRace() {
        String carNamesWithComma = inputView.getCarNamesWithComma();
        List<Car> cars = Arrays.stream(carNamesWithComma.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        return new Race(cars);
    }

    private int prepareTries() {
        return inputView.getNumberOfRounds();
    }

    public void runRaces() {
        resultView.printResultHeader();
        for (int i = 0; i < tries; i++) {
            race.runRace();
            resultView.displayRaceResult(race.getCars());
        }
        resultView.printFinalWinner(race.getCars());
    }
}
