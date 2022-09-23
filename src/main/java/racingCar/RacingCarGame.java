package racingCar;

import racingCar.view.InputView;

public class RacingCarGame {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.play();
    }

    public void play(){
        InputView inputView = new InputView();
        int numberOfCars = inputView.askHowMayCars();
        int numberOfTimes = inputView.askHowManyTimes();
    }
}
