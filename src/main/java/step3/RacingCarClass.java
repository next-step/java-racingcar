package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarClass {
    public static void main(String arg[]) {
        int carNumber = InputView.inputCarNumber();
        int chanceNumber = InputView.inputChanceNumber();

        RacingGame racingGame = new RacingGame(carNumber);
        racingGame.playRacingGames(chanceNumber);
    }

}
