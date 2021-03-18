package carRacing;

import carRacing.view.InputView;

public class CarRacingApplication {
    public static void main(String[] args){

        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        int racingCount = inputView.getRacingCount();
        CarRacing carRacing = new CarRacing(carNames);

        carRacing.startRacing(racingCount);

        carRacing.racingWinner();
    }
}
