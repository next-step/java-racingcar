package ui;

import racing.RacingCars;

public class ResultView {

    public static void showRaceResult(RacingCars racingCars, int tryCount) {
        if (tryCount == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }

        for (int i = 0; i < racingCars.getCarList().size(); i++) {
            showCarLocation(racingCars.getCarList().get(i).getLocation());
            System.out.println();
        }
        System.out.println();
    }

    private static void showCarLocation(Integer location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }
}
