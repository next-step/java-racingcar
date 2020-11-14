package racing.ui;

import racing.RacingGame;

public class ResultView {

    private static final String FORWARD_MARK = "-";

    public static void raceResult(int participationCars, int numberOfAttempt) {
        printReady();
        printStart(participationCars, numberOfAttempt);
    }

    private static void printReady() {
        System.out.println("실행결과");
        System.out.println();
    }

    private static void printStart(int participationCars, int numberOfAttempt) {
        RacingGame racingGame = new RacingGame(participationCars);

        for (int i = 0; i < numberOfAttempt; i++) {
            racingGame.go();
            printManager(racingGame);
            printAttemptDividingLine();
        }
    }


    private static void printManager(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getCarsSize(); i++) {
            printResult(racingGame, i);
        }
    }

    private static void printResult(RacingGame racingGame, int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < racingGame.getCar(number).getPosition(); i++) {
            stringBuilder.append(FORWARD_MARK);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void printAttemptDividingLine() {
        System.out.println("========================");
    }
}
