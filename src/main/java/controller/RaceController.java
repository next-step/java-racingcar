package controller;

import model.MoveStrategy;
import model.Race;
import view.RaceView;

public class RaceController {
    private final Race race;
    private final RaceView raceView;

    public RaceController(Race race, RaceView raceView) {
        this.race = race;
        this.raceView = raceView;
    }

    public void startRace(MoveStrategy moveStrategy) {
        initializeRaceFromUserInput();
        var stepsToRun = raceView.queryAndGetSteps();
        raceView.printResultTitle();
        runRaceNStepsWithStrategy(stepsToRun, moveStrategy);
        raceView.printWinners(race.getWinnerNames());
    }

    private void initializeRaceFromUserInput() {
        var numberOfCars = raceView.queryAndGetNamesOfCars();
        race.resetWithCarsOf(numberOfCars);
    }

    private void runRaceNStepsWithStrategy(int steps, MoveStrategy moveStrategy) {
        for (int i = 0; i < steps; ++i) {
            race.progress(moveStrategy);
            raceView.printCurrentRaceStatus(race.getCarPositions());
        }
    }
}
