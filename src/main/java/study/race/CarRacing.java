package study.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        System.out.println("\nExecution Results");
        this.viewResult.printResult(runTrack.getRaceResult());
        for (int i = 0; i < roundOfTrack; i++) {
            runTrack.start();
            this.viewResult.printResult(runTrack.getRaceResult());
        }
    }
}
