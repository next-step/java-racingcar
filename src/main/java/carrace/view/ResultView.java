package carrace.view;

import carrace.domain.RaceTrack;

public class ResultView {
    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(RaceTrack raceTrack) {
        System.out.println(raceTrack.getRacingResult());
    }

    public static void printWinner(RaceTrack raceTrack) {
        System.out.println(raceTrack.getWinnerResult());
    }

}
