import step4.ResultView;
import step5.domain.Race;
import step5.view.InputView;

import java.util.Scanner;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.requestCars();
        int round = inputView.requestRound();

        Race race = new Race(carNames.split(","), round);
        race.startGame();
    }
}
