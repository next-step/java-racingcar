package study.race.controller;

import study.race.model.Cars;
import study.race.model.RacingRegister;
import study.race.model.Racing;
import study.race.view.ReceiveInputValue;
import study.race.view.ViewResult;

public class CarRacing {

    private ViewResult viewResult;
    private RacingRegister racingRegister;
    private ReceiveInputValue receiveInputValue;

    public CarRacing() {
        this.viewResult = new ViewResult();
        this.racingRegister = new RacingRegister();
        this.receiveInputValue = new ReceiveInputValue();
    }

    public void runCarRacing() {
        String carNames =  this.receiveInputValue.receiveInputValueForCarNames();
        int roundOfTrack = this.receiveInputValue.receiveInputValueForRound();

        Cars cars = this.racingRegister.register(carNames);
        Racing racing = new Racing(cars);

        System.out.println("\nExecution Result");
        for (int i = 0; i < roundOfTrack; i++) {
            racing.start();
            this.viewResult.printRacingResult(racing.getRaceResult());
        }
        this.viewResult.printRacingWinners(racing.getWinners());
    }
}
