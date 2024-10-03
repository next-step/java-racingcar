package racinggame;

import racinggame.racingcar.*;
import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final MoveStrategy moveStrategy;

    public RacingGameController(InputView inputView, ResultView resultView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.moveStrategy = moveStrategy;
    }

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        RacingGameController controller = new RacingGameController(inputView, resultView, moveStrategy);
        controller.run();
    }

    public void run() {
        List<String> namesOfCars = inputView.readNamesOfCars();
        int numberOfRounds = inputView.readNumberOfRounds();

        Race race = initializeRace(namesOfCars);
        conductRace(race, numberOfRounds);
    }

    private Race initializeRace(List<String > namesOfCars) {
        Race race = Race.create(moveStrategy, namesOfCars);
        resultView.printResultMessage();
        return race;
    }

    private void conductRace(Race race, int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            conductSingleRound(race);
        }
    }

    private void conductSingleRound(Race race) {
        race.proceedRound();
        resultView.printRaceResults(race.collectResults());
    }
}
