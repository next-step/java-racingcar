package step3;


import step3.controller.CarRacingController;
import step3.view.InputView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        CarRacingController.startGame(InputView.inputCarCount(), InputView.inputRoundCount());
    }
}
