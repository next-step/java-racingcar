package step3;

import step3.controller.RacingController;
import step3.util.InputView;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        RacingController controller = new RacingController(inputView);
        int gameCount = controller.initGame();
        controller.startRace(gameCount);
        controller.getWinner();

        inputView.closeScanner();
    }
}
