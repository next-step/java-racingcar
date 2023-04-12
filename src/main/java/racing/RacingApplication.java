package racing;

import java.util.List;
import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.inputCarCount();
        int opportunity = inputView.inputOpportunity();

        RacingGame racingGame = new RacingGame(carCount);
        racingGame.start(opportunity);

    }
}
