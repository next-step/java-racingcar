package carRacing;

import carRacing.view.InputView;

public class CarRacingApplication {
    public static void main(String[] args){

        InputView inputView = new InputView();
        int carCount = inputView.getCarCount();
        int racingCount = inputView.getRacingCount();



    }
}
