package study.race.controller;

import study.race.view.ReceiveInputValue;
import study.race.model.RunTrack;
import study.race.view.ViewResult;

public class CarRacing {

    private ReceiveInputValue receiveInputValue;
    private ViewResult viewResult;

    public CarRacing() {
        this.receiveInputValue = new ReceiveInputValue();
        this.viewResult = new ViewResult();
    }

    public void runCarRacing() {
        int numberOfCar = receiveInputValue.receiveInputValueForCar();
        int roundOfTrack = receiveInputValue.receiveInputValueForRound();

        RunTrack runTrack = new RunTrack(numberOfCar);

        System.out.println("\nExecution Result");
        this.viewResult.printResult(runTrack.getRaceResult());
        for (int i = 0; i < roundOfTrack; i++) {
            runTrack.start();
            this.viewResult.printResult(runTrack.getRaceResult());
        }
    }
}
