package study.race.controller;

import study.race.model.CarRacingInputManager;
import study.race.model.RaceResister;
import study.race.model.RunTrack;
import study.race.view.ViewResult;

public class CarRacing {

    private ViewResult viewResult;

    public CarRacing() {
        this.viewResult = new ViewResult();
    }

    public void runCarRacing() {
        RaceResister raceResister = new CarRacingInputManager().getRaceInfo();
        RunTrack runTrack = new RunTrack(raceResister.getCarNames());

        System.out.println("\nExecution Result");
        for (int i = 0; i < raceResister.getRoundOfTrack(); i++) {
            runTrack.start();
            this.viewResult.printRaceResult(runTrack.getRaceResult());
        }
    }
}
