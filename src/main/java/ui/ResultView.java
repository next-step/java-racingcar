package ui;

import racing.Car;

public class ResultView {

    public static void showRaceResult(Car[] carArr, int tryCount) {
        if (tryCount == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }

        for (int i = 0; i < carArr.length; i++) {
            showCarLocation(carArr[i].getCarLocationInfo().getLocation());
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
