package car_racing2.view;

import car_racing2.model.RaceResult;

public class OutputView {
    public static void showRaceResult(RaceResult raceResult) {
        System.out.println("\n실행 결과");
        System.out.println(raceResult.getResultOfRounds());
        System.out.println(raceResult.getWinners() + "가 최종 우승했습니다.");
    }
}
