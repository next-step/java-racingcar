package raingcar;

import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Application {
    public static  void main(String[] args) {
        RacingInput intput = new RacingInput();
        String carNames = intput.getCars();
        int     rap = intput.getRap();

        RacingGame game = new RacingGame(carNames);
        game.play(rap);
        RacingStatus display = new RacingStatus();
        display.displayWiner(game.getWinner());
    }
}
