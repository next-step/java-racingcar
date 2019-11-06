package racing;

import java.util.Scanner;

public class RacingGameMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingInputCarCountView racingInputCarCountView = new RacingInputCarCountView(scanner);
        RacingInputTimeView racingInputTimeView = new RacingInputTimeView(scanner);
        scanner.close();

        RacingGame racingGame = new RacingGame(racingInputCarCountView.carName, racingInputTimeView.time);
        racingGame.open();
    }

}
