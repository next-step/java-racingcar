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
        String[] names;
        do {
            String namesOfCar = receiveInputValue.receiveInputValueForCarNames();

             names = namesOfCar.split(",");
        } while (checkLengthLimitOfCarName(names));

        int roundOfTrack = receiveInputValue.receiveInputValueForRound();

        RunTrack runTrack = new RunTrack(names);

        System.out.println("\nExecution Result");
        this.viewResult.printResult(runTrack.getRaceResult());
        for (int i = 0; i < roundOfTrack; i++) {
            runTrack.start();
            this.viewResult.printResult(runTrack.getRaceResult());
        }
    }

    public boolean checkLengthLimitOfCarName(String[] names) {
        for (String name: names) {
            if (name.length() > 5) {
                System.out.println("The length of the car name '" + name + "' exceeds 5.");
                return false;
            }
        }
        return true;
    }
}
