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
        int numberOfCars = inputView.readNumberOfCars();
        int numberOfRounds = inputView.readNumberOfRounds();

        Race race = initializeRace(numberOfCars);
        conductRace(race, numberOfRounds);
    }

    private Race initializeRace(int numberOfCars) {
        Race race = Race.create(numberOfCars, moveStrategy);
        resultView.printResultMessage();
        return race;
    }

    private void conductRace(Race race, int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            List<Integer> roundResult = race.proceedRounds();
            resultView.printRaceResults(roundResult);
        }
    }
}
