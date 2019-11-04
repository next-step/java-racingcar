package step1.racing.view;

import step1.racing.RacingGame;

public class CarPositionViewer {
    public static void printStatus(RaceSnapshot snapshot, String notice) {
        System.out.println(notice);
        System.out.println(snapshot.toString());
    }

    public static void printWinner(RacingGame racingGame, String notice) {
        System.out.println(notice);
        racingGame.getWinners().forEach(car -> System.out.print(car.getName()));
    }
}
