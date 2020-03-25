package racingGame;

import java.util.Scanner;

public class RacingGameApp {

    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = InputView.cars();

        int roundNumber = 0;
        if (carNumber > 0) {
            System.out.println("시도할 회수는 몇 회 인가요?");
            roundNumber = InputView.rounds();
        }

        if (roundNumber > 0) {
            RacingGame racingGame = new RacingGame(carNumber, roundNumber);
            racingGame.racing();
        }
    }
}
