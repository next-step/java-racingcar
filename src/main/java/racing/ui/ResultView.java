package racing.ui;

import racing.*;

public class ResultView {

    private static final String FORWARD_MARK = "-";

    private static void printReady() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void output(RacingGame racingGame, RacingWinner racingWinner) {
        printReady();
        printStart(racingGame);
        System.out.println("우승자는 :  " + racingWinner.getWinners());
    }

    private static void printStart(RacingGame racingGame) {
        int roundSize = racingGame.size();

        for (int round = 0; round < roundSize; round++) {
            printManager(racingGame, round);
        }
    }

    private static void printManager(RacingGame racingRound, int round) {
        Cars cars = racingRound.getLastRoundResult();
        int carsSize = cars.size();

        for (int i = 0; i < carsSize; i++) {
            print(cars.getCar(i));
        }

        printAttemptDividingLine();
    }

    private static void print(Car car) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(FORWARD_MARK);
        }

        System.out.println(car.getName() + " : " + sb.toString());
    }

    private static void printAttemptDividingLine() {
        System.out.println("========================");
    }
}
