package controller;

import model.Race;
import view.RaceView;

public class RaceController {
    private final Race race;
    private final RaceView raceView;

    public RaceController(Race race, RaceView raceView) {
        this.race = race;
        this.raceView = raceView;
    }

    public void startRace() {
        initializeRaceFromUserInput();
        var stepsToRun = raceView.queryAndGetSteps();
        raceView.printResultTitle();
        runRaceNSteps(stepsToRun);
    }

    private void initializeRaceFromUserInput() {
        var numberOfCars = raceView.queryAndGetNumberOfCars();
        race.resetWithCarsOf(numberOfCars);
    }

    private void runRaceNSteps(int steps) {
        for (int i = 0; i < steps; ++i) {
            race.progress();
            raceView.printCurrentRaceStatus(race.getCarPositions());
        }
    }
}
