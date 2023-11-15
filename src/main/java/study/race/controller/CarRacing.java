package study.race.controller;

import study.race.model.CarRacingInputManager;
import study.race.model.RaceInfo;
import study.race.view.ReceiveInputValue;
import study.race.model.RunTrack;
import study.race.view.ViewResult;

public class CarRacing {

    private ReceiveInputValue receiveInputValue;
    private ViewResult viewResult;

    public CarRacing() {
        this.viewResult = new ViewResult();
    }

    public void runCarRacing() {
        RaceInfo raceInfo = new CarRacingInputManager().getRaceInfo();
        RunTrack runTrack = new RunTrack(raceInfo.getCarNames());

        System.out.println("\nExecution Result");
        for (int i = 0; i < raceInfo.getRoundOfTrack(); i++) {
            runTrack.start();
            this.viewResult.printResult(runTrack.getRaceResult());
        }
    }
}
